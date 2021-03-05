package com.evertec.edson.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.evertec.edson.R
import com.evertec.edson.databinding.LayoutMyPaymentsFragmentBinding

class MyPaymentsFragment : Fragment() {
    private lateinit var myPaymentsFragmentBinding: LayoutMyPaymentsFragmentBinding

    /**
     * Method to instantiate the view
     * */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myPaymentsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.layout_my_payments_fragment, container, false)
        return myPaymentsFragmentBinding.root
    }
}