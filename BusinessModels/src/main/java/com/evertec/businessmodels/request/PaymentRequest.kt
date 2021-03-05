package com.evertec.businessmodels.request

import com.evertec.businessmodels.business.Payment

data class PaymentRequest(
    val locale : String = "es_CO",
    val auth : Auth = Auth(),
    val instrument: Instrument = Instrument(),
    val payment : Payment = Payment()
)