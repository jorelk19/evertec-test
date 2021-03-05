package com.evertec.businessmodels.request

data class Amount(
    val currency: String = "",
    val total: Double = 0.0
)