package com.evertec.businessmodels.request

data class Auth(
    val login : String = "",
    val tranKey : String = "",
    val nonce : String = "",
    val seed : String = ""
)