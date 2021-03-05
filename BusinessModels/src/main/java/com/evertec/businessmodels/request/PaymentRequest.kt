package com.evertec.businessmodels.request

data class PaymentRequest(
    val auth : Auth = Auth(),
    val reference : String = "",
    val amount : Amount
)