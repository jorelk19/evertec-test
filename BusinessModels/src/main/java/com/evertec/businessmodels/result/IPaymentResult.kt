package com.evertec.businessmodels.result

import com.evertec.businessmodels.response.PaymentResponse

interface IPaymentResult {
    fun setInformationRequest(paymentResponse: PaymentResponse)
}