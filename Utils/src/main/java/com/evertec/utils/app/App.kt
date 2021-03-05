package com.evertec.utils.app

import android.content.Context
import com.evertec.di.KoinManager
import com.evertec.utils.ViewManager
import com.evertec.utils.connectivity.base.BaseConnectivityProvider

/**
 * Class used to get the application instance and call the koin dependency injection
 * @since 1.0.0
 * */
open class App : BaseApplication() {
    private val providerBase: BaseConnectivityProvider by lazy {
        BaseConnectivityProvider.createProvider(
            this@App
        )
    }

    /**
     * Object to manage the internet connection
     * */

    private val connectivityStateListener =
        object : BaseConnectivityProvider.ConnectivityStateListener {
            override fun onStateChange(state: BaseConnectivityProvider.NetworkState) {
                ViewManager.getInstance.setInternetConnection(state.hasInternet())
            }

            private fun BaseConnectivityProvider.NetworkState.hasInternet(): Boolean {
                return (this as? BaseConnectivityProvider.NetworkState.ConnectedState)?.hasInternet == true
            }
        }


    /**
     * Get the application context
     * */
    companion object {
        private lateinit var appContext: Context
        final fun getAppContext(): Context = appContext
    }

    /**
     * Method that allow start koin dependency injection
     * */
    override fun onAppStart() {
        appContext = this
        KoinManager.initKoin()
        providerBase.addListener(connectivityStateListener)
        KoinManager.startRepositoryRealm(this)
    }

    /**
     * Method that is executed when the application is finish
     * */
    override fun onAppDestroy() {
    }
}