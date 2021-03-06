package com.evertec.edson.ui.viewModels

import com.evertec.edson.ui.models.HeaderModel
import com.evertec.edson.ui.viewModels.base.BaseViewModel
import com.evertec.utils.ViewManager

/**
 * Class used to manage the view model for the header view
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class HeaderViewModel : BaseViewModel() {
    var headerModel = HeaderModel()

    /**
     * Function to execute back in header button
     * */
    fun onBackHeader(){
        ViewManager.getInstance.onBack()
    }

    /**
     * Method to set the values in header
     * */
    fun setHeaderValues(headerTitle: String, isBackVisibility: Boolean) {
        headerModel.headerTitle = headerTitle
        headerModel.isBackVisibility = isBackVisibility
    }
}