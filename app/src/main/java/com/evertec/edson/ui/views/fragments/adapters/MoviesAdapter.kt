package com.evertec.edson.ui.views.fragments.adapters

import android.content.Context
import com.evertec.businessmodels.business.Movie
import com.evertec.edson.R
import com.evertec.edson.databinding.LayoutMovieItemBinding
import com.evertec.edson.ui.viewModels.MovieItemViewModel
import com.evertec.utils.GenericAdapter

/**
 * Class used to set the data for the recycler view that show the movie list
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class MoviesAdapter(context: Context, movies: ArrayList<Movie>) : GenericAdapter<Movie, LayoutMovieItemBinding>(context, movies) {

    /**
     * Method to retrieve the layout for the item in recycler view
     * */
    override fun getLayoutResId(): Int {
        return R.layout.layout_movie_item
    }

    /**
     * Method that allow load information into view model
     * */
    override fun onBindData(model: Movie, position: Int, dataBinding: LayoutMovieItemBinding) {
        val movieItemViewModel = MovieItemViewModel()
        dataBinding.itemViewModel = movieItemViewModel
        movieItemViewModel.setMovieData(model)
    }
}