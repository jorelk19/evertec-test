package com.evertec.edson.ui.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.evertec.businessmodels.response.PaymentResponse
import com.evertec.edson.R
import com.evertec.edson.databinding.ActivityNotificationBinding
import com.evertec.edson.ui.utils.getViewModelFactory
import com.evertec.edson.ui.viewModels.NotificationViewModel
import com.evertec.edson.ui.views.activities.base.BaseFragmentActivity
import com.evertec.utils.fromJson
import com.evertec.utils.loadLocalImage

class NotificationActivity : BaseFragmentActivity() {
    private lateinit var binding: ActivityNotificationBinding
    private val viewModel by viewModels<NotificationViewModel> { getViewModelFactory() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@NotificationActivity, R.layout.activity_notification)
        binding.viewModel = viewModel
        getExtras()
        addSubscriptions()
    }

    private fun addSubscriptions() {
        binding.ivClose.setColorFilter(R.color.fontDarkGray)
        viewModel.getImageState().observe(this, Observer {
            binding.ivCheck.setImageDrawable(it)
        })
    }

    private fun getExtras() {
        intent.extras?.let {
            it.getString(PAYMENT_RESPONSE)?.let {
                val paymentResponse = it.fromJson<PaymentResponse>()
                viewModel.setNotificationInformation(paymentResponse)
            }
        }
    }

    companion object {
        const val PAYMENT_RESPONSE = "PAYMENT_RESPONSE"
    }
}