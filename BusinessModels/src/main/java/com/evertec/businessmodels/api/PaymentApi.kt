package com.evertec.businessmodels.api

import com.evertec.businessmodels.request.PaymentRequest
import com.evertec.businessmodels.response.PaymentResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface PaymentApi {
        @POST("/rest/gateway/information")
    suspend fun informationRequest(@Body paymentRequest: PaymentRequest): PaymentResponse
}