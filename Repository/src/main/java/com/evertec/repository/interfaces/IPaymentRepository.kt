package com.evertec.repository.interfaces

import com.evertec.businessmodels.request.PaymentRequest
import com.evertec.businessmodels.response.PaymentResponse

interface IPaymentRepository {
    suspend fun processTransaction(paymentRequest : PaymentRequest) : PaymentResponse
}