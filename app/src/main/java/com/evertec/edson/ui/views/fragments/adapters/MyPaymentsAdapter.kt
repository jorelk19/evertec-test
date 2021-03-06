package com.evertec.edson.ui.views.fragments.adapters

import android.content.Context
import com.evertec.businessmodels.response.PaymentResponse
import com.evertec.edson.R
import com.evertec.edson.databinding.LayoutMyPaymentItemBinding
import com.evertec.utils.GenericAdapter
import com.evertec.utils.toCurrencyFormat

class MyPaymentsAdapter(context: Context, myPayments : ArrayList<PaymentResponse>) : GenericAdapter<PaymentResponse, LayoutMyPaymentItemBinding>(context, myPayments) {
    override fun getLayoutResId(): Int {
        return R.layout.layout_my_payment_item
    }

    override fun onBindData(model: PaymentResponse, position: Int, dataBinding: LayoutMyPaymentItemBinding) {
        dataBinding.tvInternalReference.text = model.internalReference.toString()
        dataBinding.tvMyPaymentState.text = model.status.message
        dataBinding.tvMyPaymentTotalAmount.text = model.amount.total.toCurrencyFormat()
        dataBinding.tvPaymentDate.text = model.date
    }

}