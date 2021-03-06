package com.evertec.domain

import com.evertec.businessmodels.business.Payment
import com.evertec.businessmodels.request.*
import com.evertec.businessmodels.result.IPaymentResult
import com.evertec.domain.base.DomainManager
import com.evertec.domain.utils.AuthenticationManager
import com.evertec.repository.interfaces.IPaymentRepository
import com.evertec.utils.ViewManager
import com.evertec.utils.security.CryptoTools
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

class PaymentDomain(private val paymentRepository: IPaymentRepository) : DomainManager<IPaymentResult>() {
    private lateinit var currentPaymentResult: IPaymentResult
    override fun domainResult(paymentResult: IPaymentResult) {
        currentPaymentResult = paymentResult
    }

    fun getPaymentInformation(payment: Payment, currentCard: Card) {
        launch(Dispatchers.Main) {
            try {
                errorManager.onShowLoader()
                val nonce = CryptoTools.getPlainNonce()
                val paymentRequest = PaymentRequest(
                    auth = AuthenticationManager.buildAuthentication(nonce),
                    instrument = Instrument(
                        card = currentCard,
                        credit = Credit()
                    ),
                    payment = payment
                )

                val information = withContext(Dispatchers.IO) { paymentRepository.informationPayment(paymentRequest) }
                currentPaymentResult.setInformationRequest(information)
                errorManager.onHideLoader()
            } catch (exception: HttpException) {
                errorManager.onServiceErrorHttpException(exception.message, exception)
            } catch (exception: SocketTimeoutException) {
                errorManager.onSocketTimeoutException(exception.message)
            } catch (exception: IOException) {
                errorManager.onSocketTimeoutException(exception.message)
            } catch (exception: Exception) {
                errorManager.onSocketTimeoutException(exception.message)
            }
        }
    }
}