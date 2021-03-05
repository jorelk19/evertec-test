package com.evertec.domain

import com.evertec.businessmodels.request.PaymentRequest
import com.evertec.businessmodels.result.IPaymentResult
import com.evertec.domain.base.DomainManager

class PaymentDomain : DomainManager<IPaymentResult>() {
    private lateinit var currentPaymentResult: IPaymentResult
    override fun domainResult(paymentResult: IPaymentResult) {
        currentPaymentResult = paymentResult
    }

    fun getPaymentPlaceToPAY(payment : PaymentRequest){

    }
}