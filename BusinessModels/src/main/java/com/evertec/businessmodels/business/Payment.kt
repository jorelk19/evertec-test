package com.evertec.businessmodels.business

import com.evertec.businessmodels.request.Amount

data class Payment(
    val reference :String = "",
    val amount: Amount = Amount()
)