package com.evertec.edson.ui.viewModels

import androidx.lifecycle.MutableLiveData
import com.evertec.domain.PaymentDomain
import com.evertec.edson.ui.viewModels.base.BaseViewModel

class PaymentViewModel(val paymentDomain: PaymentDomain) : BaseViewModel() {
    /*Payment Information*/
    val cardNumber = MutableLiveData<String>()
    val cvvNumber =  MutableLiveData<Int>()
    val expirationDate = MutableLiveData<String>()
    val cardName = MutableLiveData<String>()
    val totalPayment = MutableLiveData<String>()
    val buttonPaymentEnabled = MutableLiveData<Boolean>()

    /*Visual Information*/
    val cardNumberDescription = MutableLiveData<String>()
    val cvvNumberDescription =  MutableLiveData<Int>()
    val expirationDateDescription = MutableLiveData<String>()
    val cardNameDescription = MutableLiveData<String>()

    fun paymentButtonClick(){

    }
}