package com.evertec.businessmodels.response

data class PaymentResponse(
    var status: Status? = null,
    var provider: String? = null,
    var serviceCode: String? = null,
    var cardType: String? = null,
    var cardTypes: List<String>? = null,
    var displayInterest: Boolean = false,
    var requireOtp: Boolean = false,
    var requireCvv2: Boolean = false,
    var threeDS: String? = null,
    var credits: List<Credit>? = null
)

class Status {
    var status: String? = null
    var reason: String? = null
    var message: String? = null
    var date: String? = null
}

data class Credit(
    var code: Int = 0,
    var type: String? = null,
    var groupCode: String? = null,
    var installments: List<Int>? = null,
    var installment: Int = 0,
    var description: String? = null
)
