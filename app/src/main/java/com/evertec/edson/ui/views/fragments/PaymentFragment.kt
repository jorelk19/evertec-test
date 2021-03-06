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
import com.evertec.utils.ViewManager
import com.evertec.utils.doOnTextChange
import java.util.*

class PaymentFragment : Fragment(){

    private lateinit var paymentFragmentBinding: LayoutPaymentFragmentBinding
    private val viewModel by viewModels<PaymentViewModel> { getViewModelFactory() }
    private var currentDate = ""
    /**
     * Method to instantiate the view
     * */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        paymentFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.layout_payment_fragment, container, false)
        paymentFragmentBinding.viewModel = viewModel
        setListeners()
        addSubscriptions()
        return paymentFragmentBinding.root
    }

    private fun addSubscriptions() {
        viewModel.validateFields()
    }

    private fun setListeners() {
        paymentFragmentBinding.etCardDate.doOnTextChange { s, before -> validateDate(s, before) }
    }

    private fun validateDate(s: CharSequence, before: Int) {
        var working = viewModel.cleanDateString(s.toString())
        var isValid = true
        if (working != currentDate) {
            currentDate = working
            if (working.length == 2 && before == 0) {
                if (Integer.parseInt(working) < 1 || Integer.parseInt(working) > 12) {
                    isValid = false
                    setDateEmptyText()
                } else {
                    working += PaymentViewModel.DATE_DIVIDER
                    setDateText(viewModel.getStringDate(working))
                    paymentFragmentBinding.etCardDate.setSelection(working.length)
                }
            } else if (working.length == 5 && before == 0) {
                val enteredYear = working.substring(3)
                val currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100
                if (Integer.parseInt(enteredYear) < currentYear) {
                    isValid = false
                    paymentFragmentBinding.etCardDate.setText(viewModel.getStringDate(working.subSequence(0, 3).toString()))
                    paymentFragmentBinding.etCardDate.setSelection(3)
                } else {
                    setDateText(viewModel.getStringDate(working))
                    paymentFragmentBinding.etCardDate.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(5))
                }
            } else if (working.length != 5) {
                if (working.isEmpty() && before == 0) {
                    setDateEmptyText()
                } else if (working.length == 3 && before == 0) {
                    setDateText(viewModel.getStringDate(working.subSequence(0, 2).toString() + PaymentViewModel.DATE_DIVIDER))
                    paymentFragmentBinding.etCardDate.setSelection(3)
                } else {
                    setDateText(viewModel.getStringDate(working))
                }
                paymentFragmentBinding.etCardDate.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(6))
                isValid = false
            }
            paymentFragmentBinding.etCardDate.setSelection(working.length)
        }
    }

    private fun setDateText(dateString: String) {
        paymentFragmentBinding.etCardDate.setText(dateString)
        paymentFragmentBinding.tvDateExpired.text = dateString
    }

    private fun setDateEmptyText() {
        paymentFragmentBinding.etCardDate.setText(viewModel.getStringDate(PaymentViewModel.DATE_EMPTY))
        paymentFragmentBinding.tvDateExpired.text = viewModel.getStringDate(PaymentViewModel.DATE_MM_YY)
    }
}