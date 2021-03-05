package com.evertec.edson.ui.views.activities.splashScreen

import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.evertec.edson.R
import com.evertec.edson.databinding.ActivitySplashScreenBinding
import com.evertec.edson.ui.utils.getViewModelFactory
import com.evertec.edson.ui.viewModels.SplashScreenViewModel
import com.evertec.edson.ui.viewModels.base.ViewModelFactory
import com.evertec.edson.ui.views.activities.SignInActivity
import com.evertec.edson.ui.views.activities.base.BaseFragmentActivity
import com.evertec.utils.ViewManager

/**
 * Activity use to show splash screen when the application start
 * @author Edson Joel Nieto Ardila *
 * @since 1.0.0
 * */
class SplashScreenActivity : BaseFragmentActivity() {

    private lateinit var activitySplashScreenBinding: ActivitySplashScreenBinding
    private val viewModel by viewModels<SplashScreenViewModel>{ getViewModelFactory() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySplashScreenBinding = DataBindingUtil.setContentView(this@SplashScreenActivity, R.layout.activity_splash_screen)
        viewModel.createDefaultUser()
        Handler().postDelayed(Runnable {
            ViewManager.getInstance.goTo(SignInActivity::class.java)
            this.finish()
        }, 2000)
    }
}