package com.evertec.di

import com.evertec.businessmodels.api.SignInApi
import com.evertec.repository.implementation.DefaultUserLocalRepository
import com.evertec.repository.implementation.SignInRepository
import org.koin.dsl.module

/**
 * Variable used to load the repository modules that can be used in the application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */

private fun provideSignInRepository(signInApi: SignInApi) = SignInRepository(signInApi)
private fun provideDefaultUserRepository() = DefaultUserLocalRepository()

val repositoryModule = module {
    single { provideSignInRepository(get()) }
    single { provideDefaultUserRepository() }
}


