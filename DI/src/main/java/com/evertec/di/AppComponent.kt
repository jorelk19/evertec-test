package com.evertec.di

import com.evertec.domain.SignInDomain
import com.evertec.domain.SplashScreenDomain
import com.evertec.repository.implementation.SignInRepository

/**
 * Class used to manage the components from application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
data class AppComponent(
    val signInRepository: SignInRepository,
    val signInDomain: SignInDomain,
    val splashScreenDomain: SplashScreenDomain
)
