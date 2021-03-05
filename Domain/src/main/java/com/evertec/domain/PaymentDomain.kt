package com.evertec.domain

import com.evertec.businessmodels.business.Payment
import com.evertec.businessmodels.request.Auth
import com.evertec.businessmodels.request.PaymentRequest
import com.evertec.businessmodels.result.IPaymentResult
import com.evertec.domain.base.DomainManager
import com.evertec.repository.interfaces.IPaymentRepository
import com.evertec.utils.ViewManager
import com.evertec.utils.security.CryptoTools
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

    fun getPaymentPlaceToPAY(payment : Payment){
        launch(Dispatchers.Main) {
            try {
                errorManager.onShowLoader()
                val paymentRequest = PaymentRequest(
                    auth = Auth(
                        login = ViewManager.getInstance.getString(R.string.login_service)

                    )
                )
                val information = withContext(Dispatchers.IO) { paymentRepository.informationPayment(paymentRequest) }
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