package com.evertec.businessmodels.response

import com.evertec.businessmodels.business.Amount
import com.evertec.businessmodels.business.Conversion
import com.evertec.businessmodels.business.Status


data class PaymentResponse(
    var email: String = "",
    var status: Status = Status(),
    var date: String = "",
    var transactionDate: String = "",
    var internalReference: Int = 0,
    var reference: String = "",
    var paymentMethod: String = "",
    var franchise: String = "",
    var franchiseName: String = "",
    var issuerName: String = "",
    var amount: Amount = Amount(),
    var conversion: Conversion = Conversion(),
    var authorization: String = "",
    var receipt: String = "",
    var type: String = "",
    var refunded: Boolean = false,
    var lastDigits: String = "",
    var provider: String? = ""
)