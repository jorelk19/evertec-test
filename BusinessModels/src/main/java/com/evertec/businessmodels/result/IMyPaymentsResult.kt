package com.evertec.businessmodels.result

import com.evertec.businessmodels.response.PaymentResponse

interface IMyPaymentsResult {
    fun setMyPayments(payments : ArrayList<PaymentResponse>)
}