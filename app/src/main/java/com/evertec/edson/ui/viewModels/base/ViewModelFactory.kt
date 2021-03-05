package com.evertec.edson.ui.viewModels.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.evertec.di.KoinManager
import com.evertec.edson.ui.viewModels.MovieDetailViewModel
import com.evertec.edson.ui.viewModels.SignInViewModel
import com.evertec.edson.ui.viewModels.SplashScreenViewModel

/**
 * Class used to create view models through factory pattern
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    /**
     * Method to return instance from specific view model
     * */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass)
        {
            when {
                isAssignableFrom(SignInViewModel::class.java) -> SignInViewModel(KoinManager.getAppComponent().signInDomain)
                isAssignableFrom(MovieDetailViewModel::class.java) -> MovieDetailViewModel()
                isAssignableFrom(SplashScreenViewModel::class.java) -> SplashScreenViewModel(KoinManager.getAppComponent().splashScreenDomain)
                else -> throw IllegalStateException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}