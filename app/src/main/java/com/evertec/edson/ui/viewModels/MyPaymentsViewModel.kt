package com.evertec.edson.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.evertec.businessmodels.response.PaymentResponse
import com.evertec.businessmodels.result.IMyPaymentsResult
import com.evertec.domain.MyPaymentsDomain
import com.evertec.edson.ui.utils.settingsSharedPreferences
import com.evertec.edson.ui.viewModels.base.BaseViewModel

class MyPaymentsViewModel(private val myPaymentsDomain: MyPaymentsDomain) : BaseViewModel() {

    val myPayments = MutableLiveData<ArrayList<PaymentResponse>>()
    fun getMyPayments(): LiveData<ArrayList<PaymentResponse>> {
        return myPayments
    }

    private val myPaymentsResult = object : IMyPaymentsResult {
        override fun setMyPayments(payments: ArrayList<PaymentResponse>) {
            myPayments.value = payments
        }
    }

    fun getMyPaymentsRepository() {
        myPaymentsDomain.errorManager = this
        myPaymentsDomain.domainResult(myPaymentsResult)
        myPaymentsDomain.getLocalPayments(settingsSharedPreferences.getCurrentUser().email)
    }
}