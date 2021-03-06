package com.evertec.edson.ui.viewModels.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.evertec.businessmodels.errors.IErrorManager
import com.evertec.di.app.App
import com.evertec.edson.R
import com.evertec.edson.ui.views.activities.MainActivity
import com.evertec.utils.ViewManager
import com.evertec.utils.SnackFactory
import com.evertec.utils.loadImage
import retrofit2.HttpException
import java.lang.Exception

/**
 * This class in charge of manage the errors that can be occurred in the domain
 * when a services is executed
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
abstract class BaseViewModel : ViewModel(), IErrorManager {
    /**
     * Method to manage the http exception
     * */
    override fun onServiceErrorHttpException(error: String?, httpException: HttpException) {
        ViewManager.getInstance.hideLoader()
        SnackFactory.showErrorMessage(httpException = httpException,
            resource = if(ViewManager.getInstance.getCurrentActivity()::class.java == MainActivity::class.java)  R.id.coordinator_main_activity else R.id.coordinatoar_login,
            fragmentActivity = ViewManager.getInstance.getCurrentActivity(),
            currentContext = App.getAppContext()
        )
    }

    /**
     * Method to manage the socket time out exception
     */
    override fun onSocketTimeoutException(error: String?) {
        ViewManager.getInstance.hideLoader()
        SnackFactory.showWarningMessage(fragmentActivity = ViewManager.getInstance.getCurrentActivity(),
            resource = if(ViewManager.getInstance.getCurrentActivity()::class.java == MainActivity::class.java)  R.id.coordinator_main_activity else R.id.coordinatoar_login,
            message = error?.let { it } ?: run { ViewManager.getInstance.getString(R.string.something_went_wrong_retry) },
            currentContext = App.getAppContext()
        )
    }

    /**
     * Method to manage the IO exception
     */
    override fun onIOException(error: String?) {
        ViewManager.getInstance.hideLoader()
        SnackFactory.showWarningMessage(fragmentActivity = ViewManager.getInstance.getCurrentActivity(),
            resource = if(ViewManager.getInstance.getCurrentActivity()::class.java == MainActivity::class.java)  R.id.coordinator_main_activity else R.id.coordinatoar_login,
            message = error?.let { it } ?: run { ViewManager.getInstance.getString(R.string.something_went_wrong_retry) },
            currentContext = App.getAppContext()
        )
    }

    /**
     * Method to hide the loader
     */
    override fun onHideLoader() {
        ViewManager.getInstance.hideLoader()
    }

    /**
     * Method to show the loader
     */
    override fun onShowLoader() {
        ViewManager.getInstance.showLoader()
    }

    /**
     * Method to manage the general exception
     */
    override fun onGeneralException(exception: Exception) {
        ViewManager.getInstance.hideLoader()
        SnackFactory.showWarningMessage(fragmentActivity = ViewManager.getInstance.getCurrentActivity(),
            resource = if(ViewManager.getInstance.getCurrentActivity()::class.java == MainActivity::class.java)  R.id.coordinator_main_activity else R.id.coordinatoar_login,
            message = exception.message?.let { it } ?: run { ViewManager.getInstance.getString(R.string.something_went_wrong_retry) },
            currentContext = App.getAppContext()
        )
    }

    companion object {
        @BindingAdapter("android:src")
        @JvmStatic
        fun loadImage(imageView: ImageView, movieImage: String) {
            if(movieImage.isNullOrEmpty()) {
                imageView.loadImage(movieImage)
            }
        }
    }
}