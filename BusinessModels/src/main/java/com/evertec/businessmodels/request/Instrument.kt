package com.evertec.businessmodels.request

data class Instrument(
    val card: Card = Card(),
    val token: String = "",
    val credit: Credit = Credit(),
    val otp: String = ""
)