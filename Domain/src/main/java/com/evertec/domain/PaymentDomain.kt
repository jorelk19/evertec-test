package com.evertec.domain

import com.evertec.businessmodels.business.Person
import com.evertec.businessmodels.business.Payment
import com.evertec.businessmodels.request.*
import com.evertec.businessmodels.response.PaymentResponse
import com.evertec.businessmodels.result.IPaymentResult
import com.evertec.domain.base.DomainManager
import com.evertec.domain.utils.AuthenticationManager
import com.evertec.repository.interfaces.IPaymentRepository
import com.evertec.repository.local.ILocalRepositoryManager
import com.evertec.repository.local.entities.PaymentResponseDTO
import com.evertec.utils.security.CryptoTools
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

class PaymentDomain(private val paymentRepository: IPaymentRepository, private val paymentLocalRepository: ILocalRepositoryManager<PaymentResponse, PaymentResponseDTO>) : DomainManager<IPaymentResult>() {
    private lateinit var currentPaymentResult: IPaymentResult
    override fun domainResult(paymentResult: IPaymentResult) {
        currentPaymentResult = paymentResult
    }

    fun processTransaction(payer: Person, payment: Payment, currentCard: Card, ipAddress : String) {
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
                    payment = payment,
                    payer = payer,
                    buyer = payer,
                    ipAddress = ipAddress
                )
                val paymentResponse = withContext(Dispatchers.IO) { paymentRepository.processTransaction(paymentRequest) }
                paymentResponse.email = payer.email
                paymentLocalRepository.create(paymentResponse)
                currentPaymentResult.setInformationRequest(paymentResponse)
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