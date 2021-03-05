package com.evertec.edson.ui.viewModels

import com.evertec.businessmodels.business.Movie
import com.evertec.edson.ui.models.SignInModel
import com.evertec.edson.ui.viewModels.base.BaseViewModel

/**
 * Class used to manage the view model for the movie detail view
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class MovieDetailViewModel : BaseViewModel() {

    var movieModel = SignInModel()

    /**
     * Method to set the movie values
     **/
    fun setMovieData(movie: Movie) {

    }
}