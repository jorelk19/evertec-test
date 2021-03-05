package com.evertec.businessmodels.business

import com.evertec.businessmodels.request.Amount

data class Payment(
    val description :String = "",
    val amount: Amount = Amount()
)