package com.evertec.businessmodels.api

import com.evertec.businessmodels.response.PaymentResponse
import retrofit2.http.GET

interface PaymentApi {
    @GET("/4/list/1")
    suspend fun informationRequest(): PaymentResponse
}