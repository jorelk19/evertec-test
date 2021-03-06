package com.evertec.repository.implementation

import com.evertec.businessmodels.api.PaymentApi
import com.evertec.businessmodels.request.PaymentRequest
import com.evertec.businessmodels.response.PaymentResponse
import com.evertec.repository.interfaces.IPaymentRepository

class PaymentRepository(private val paymentApi: PaymentApi) : IPaymentRepository {
    override suspend fun informationPayment(paymentRequest: PaymentRequest): PaymentResponse {
        return paymentApi.informationRequest(paymentRequest)
    }
}