package com.evertec.businessmodels.business

data class Conversion(
    var from: Amount = Amount(),
    var to: Amount = Amount(),
    var factor: Double = 0.0
)