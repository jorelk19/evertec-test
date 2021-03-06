package com.evertec.repository.implementation

import com.evertec.businessmodels.api.PaymentApi
import com.evertec.businessmodels.request.PaymentRequest
import com.evertec.businessmodels.response.PaymentResponse
import com.evertec.repository.interfaces.IPaymentRepository

class PaymentRepository(private val paymentApi: PaymentApi) : IPaymentRepository {
    override suspend fun processTransaction(paymentRequest: PaymentRequest): PaymentResponse {
        return paymentApi.processTransaction(paymentRequest)
    }
}