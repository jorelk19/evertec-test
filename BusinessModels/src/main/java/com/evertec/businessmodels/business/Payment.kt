package com.evertec.businessmodels.business

data class Payment(
    val reference :String = "",
    val amount: Amount = Amount()
)