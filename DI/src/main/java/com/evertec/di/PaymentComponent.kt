package com.evertec.di

import com.evertec.domain.MyPaymentsDomain
import com.evertec.domain.PaymentDomain
import com.evertec.domain.SignInDomain
import com.evertec.domain.SplashScreenDomain
import com.evertec.repository.implementation.PaymentRepository
import com.evertec.repository.implementation.SignInRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Class used to manage the koin component that can be used in the application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class PaymentComponent : KoinComponent {
    private val signInRepository : SignInRepository by inject()
    private val signInDomain : SignInDomain by inject()
    private val splashScreenDomain : SplashScreenDomain by inject()
    private val paymentDomain : PaymentDomain by inject()
    private val myPaymentsDomain : MyPaymentsDomain by inject()
    private val paymentRepository : PaymentRepository by inject()
    val appComponent = AppComponent (
        signInRepository = signInRepository,
        signInDomain = signInDomain,
        splashScreenDomain = splashScreenDomain,
        paymentDomain = paymentDomain,
        paymentRepository = paymentRepository,
        myPaymentsDomain = myPaymentsDomain
    )
}
