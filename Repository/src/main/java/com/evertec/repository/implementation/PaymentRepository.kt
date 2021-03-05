package com.evertec.repository.implementation

import com.evertec.businessmodels.api.PaymentApi
import com.evertec.businessmodels.response.PaymentResponse
import com.evertec.repository.interfaces.IPaymentRepository

class PaymentRepository(private val paymentApi: PaymentApi) : IPaymentRepository {
    override suspend fun informationPayment() : PaymentResponse{
        return paymentApi.informationRequest()
    }
}