package com.evertec.edson.ui.viewModels

import androidx.lifecycle.MutableLiveData
import com.evertec.businessmodels.business.Payment
import com.evertec.businessmodels.business.Person
import com.evertec.businessmodels.business.Amount
import com.evertec.businessmodels.request.Card
import com.evertec.businessmodels.response.PaymentResponse
import com.evertec.businessmodels.result.IPaymentResult
import com.evertec.domain.PaymentDomain
import com.evertec.edson.R
import com.evertec.edson.ui.utils.NetworkUtil
import com.evertec.edson.ui.utils.settingsSharedPreferences
import com.evertec.edson.ui.viewModels.base.BaseViewModel
import com.evertec.utils.ViewManager

class PaymentViewModel(private val paymentDomain: PaymentDomain) : BaseViewModel() {

    /*Payment Information*/
    val cardNumber = MutableLiveData<String>()
    val cvvNumber =  MutableLiveData<String>()
    val expirationDate = MutableLiveData<String>()
    val cardName = MutableLiveData<String>()
    val totalPayment = MutableLiveData<String>()
    val buttonPaymentEnabled = MutableLiveData<Boolean>()

    /*Visual Information*/
    val cardNumberDescription = MutableLiveData<String>()
    val cvvNumberDescription =  MutableLiveData<String>()
    val expirationDateDescription = MutableLiveData<String>()
    val cardNameDescription = MutableLiveData<String>()

    private val paymentResult = object : IPaymentResult{
        override fun setInformationRequest(paymentResponse: PaymentResponse) {
            val result = paymentResponse
        }
    }

    fun paymentButtonClick(){
        val card = Card(
            number = "36545400000008",//cardNumber.value ?: "",
            cvv = "123", //cvvNumber.value ?: "",
            expirationMonth = "11",//expirationDate.value?.let{ it.split("/")[0] } ?: run { "" },
            expirationYear = "22"//expirationDate.value?.let{ it.split("/")[1] } ?: run { "" }
        )

        val payment = Payment(
            reference = "Test",
            amount = Amount(
                currency = "COP",
                total = 500000.0//totalPayment.value?.let { it.toDouble() } ?: run { 0.0 }
            )
        )

        val arrayName = cardName.value?.split(" ") ?: run { arrayListOf<String>() }
        val payer = Person(
            documentType = "",
            name = "Edson",//arrayName[0],
            email = settingsSharedPreferences.getCurrentUser().email,
            document = "1032362650",
            surname = "Nieto"//if(arrayName.size > 2) arrayName[1] else ""
        )
        paymentDomain.errorManager = this
        paymentDomain.domainResult(paymentResult)
        paymentDomain.processTransaction(payer, payment, card, NetworkUtil.getIpAddress())
    }

    fun validateFields(){
        buttonPaymentEnabled.value = true
    }

    fun setPaymentButtonEnabled(isEnabled : Boolean) {
    }

    fun getStringDate(value: String): String {
        val copyDate = ViewManager.getInstance.getString(R.string.card_date)
        var newDate = copyDate.substring(0, if (value.length == 1) value.length + 1 else value.length)
        return copyDate.replace(newDate, if (value.length == 1) value + "M" else value)
    }

    fun cleanDateString(value: String): String {
        var newValue = ""
        value.forEach { char ->
            if (char.isDigit()) {
                newValue += char
            }
        }
        if (newValue.length > 2) {
            newValue = newValue.substring(0, 2) + DATE_DIVIDER + newValue.substring(2)
        }
        return if (newValue.length > 5) newValue.substring(0, 5) else newValue
    }

    companion object {
        const val DATE_DIVIDER = "/"
        const val DATE_EMPTY = ""
        const val DATE_MM_YY = "MM/YY"
    }
}