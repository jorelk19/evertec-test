package com.evertec.businessmodels.request

import java.util.*

data class Amount(
    val currency: String = "",
    val total : Double = 0.0
)