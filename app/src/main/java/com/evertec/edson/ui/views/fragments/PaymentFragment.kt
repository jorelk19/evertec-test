package com.evertec.edson.ui.views.fragments

import android.os.Bundle
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.evertec.edson.R
import com.evertec.edson.databinding.LayoutPaymentFragmentBinding
import com.evertec.edson.ui.utils.getViewModelFactory
import com.evertec.edson.ui.viewModels.PaymentViewModel
import com.evertec.utils.doOnTextChange
import java.util.*

class PaymentFragment : Fragment(){

    private lateinit var paymentFragmentBinding: LayoutPaymentFragmentBinding
    private val viewModel by viewModels<PaymentViewModel> { getViewModelFactory() }

    /**
     * Method to instantiate the view
     * */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        paymentFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.layout_payment_fragment, container, false)
        setListeners()
        addSubscriptions()
        return paymentFragmentBinding.root
    }

    private fun addSubscriptions() {

    }

    private fun setListeners() {
        //paymentFragmentBinding.etCardDate.doOnTextChange { s, before -> validateDate(s, before) }
    }

   /* private fun validateDate(s: CharSequence, before: Int) {
        var working = cleanDateString(s.toString())
        var isValid = true
        if (working != currentDate) {
            currentDate = working
            if (working.length == 2 && before == 0) {
                if (Integer.parseInt(working) < 1 || Integer.parseInt(working) > 12) {
                    isValid = false
                    setDateEmptyText()
                } else {
                    working += DATE_DIVIDER
                    setDateText(getStringDate(working))
                    paymentFragmentBinding.etCardDate.setSelection(working.length)
                }
            } else if (working.length == 5 && before == 0) {
                val enteredYear = working.substring(3)
                val currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100
                if (Integer.parseInt(enteredYear) < currentYear) {
                    isValid = false
                    paymentFragmentBinding.etCardDate.setText(getStringDate(working.subSequence(0, 3).toString()))
                    paymentFragmentBinding.etCardDate.setSelection(3)
                } else {
                    setDateText(getStringDate(working))
                    paymentFragmentBinding.etCardDate.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(5))
                }
            } else if (working.length != 5) {
                if (working.isEmpty() && before == 0) {
                    setDateEmptyText()
                } else if (working.length == 3 && before == 0) {
                    setDateText(getStringDate(working.subSequence(0, 2).toString() + DATE_DIVIDER))
                    paymentFragmentBinding.etCardDate.setSelection(3)
                } else {
                    setDateText(getStringDate(working))
                }
                paymentFragmentBinding.etCardDate.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(6))
                isValid = false
            }
            paymentFragmentBinding.etCardDate.setSelection(working.length)
        }
        isEnableStepThree = isValid
        paymentFragmentBinding.btnPayment.isEnabled = isEnableStepThree
    }*/

    companion object {
        const val EDIT_CARD = "EDIT_CARD"
        private const val DATE_DIVIDER = "/"
        private const val DATE_EMPTY = ""
        private const val DATE_MM_YY = "MM/YY"
        private const val YEARS_COMPLEMENT = "20"
        private const val MARGIN_TOP_BOTTOM = 60
        private const val MARGIN_START_END = 30

    }
}