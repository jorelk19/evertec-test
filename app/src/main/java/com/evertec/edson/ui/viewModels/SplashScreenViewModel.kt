package com.evertec.edson.ui.viewModels

import com.evertec.domain.SplashScreenDomain
import com.evertec.edson.ui.viewModels.base.BaseViewModel

class SplashScreenViewModel(private val splashScreenDomain: SplashScreenDomain) : BaseViewModel() {
    fun createDefaultUser(){
        splashScreenDomain.errorManager = this
        splashScreenDomain.createDefaultUser()
    }
}