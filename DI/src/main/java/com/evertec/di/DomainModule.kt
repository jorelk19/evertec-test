package com.evertec.di

import com.evertec.domain.SignInDomain
import com.evertec.domain.SplashScreenDomain
import com.evertec.repository.implementation.DefaultUserLocalRepository
import com.evertec.repository.implementation.SignInRepository
import org.koin.dsl.module

/**
 * Variable used to load the domain modules that can be used in the application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
val domainModule = module {
    single { provideSignInDomain(get()) }
    single { provideSplashScreenDomain(get()) }
    single { provideSplashScreenDomain(get()) }
}

private fun provideSignInDomain(signInRepository: SignInRepository) = SignInDomain(signInRepository)
private fun provideSplashScreenDomain(defaultUserLocalRepository: DefaultUserLocalRepository) = SplashScreenDomain(defaultUserLocalRepository)
private fun providePaymentDomain(defaultUserLocalRepository: DefaultUserLocalRepository) = SplashScreenDomain(defaultUserLocalRepository)

