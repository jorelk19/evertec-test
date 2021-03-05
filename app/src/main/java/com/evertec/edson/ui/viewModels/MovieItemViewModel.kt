package com.evertec.edson.ui.viewModels

import androidx.lifecycle.Observer
import com.evertec.businessmodels.business.Movie
import com.evertec.edson.R
import com.evertec.edson.ui.models.MovieItemModel
import com.evertec.edson.ui.viewModels.base.BaseViewModel
import com.evertec.edson.ui.views.fragments.MoviesDetailFragment
import com.evertec.utils.ViewManager

/**
 * Class used to manage the view model for the movie item in recycler view
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class MovieItemViewModel : BaseViewModel() {
    private lateinit var currentMovie: Movie
    val movieItemModel = MovieItemModel()
    /**
     * Method used to call the fragment to show movie detail
     * */
    fun showMovieDetail() {
        if (::currentMovie.isInitialized) {
            ViewManager.getInstance.attachFragment(MoviesDetailFragment.getInstance(currentMovie), R.id.fragment_container)
        }
    }

    /**
     * Method used to set the movie data
     * */
    fun setMovieData(model: Movie) {
        currentMovie = model
        model.title?.let {

        }
        model.posterPath?.let {
        }
    }

}