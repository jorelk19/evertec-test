package com.evertec.edson.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.evertec.edson.R
import com.evertec.edson.databinding.LayoutMoviesFragmentBinding
import com.evertec.edson.ui.utils.getViewModelFactory
import com.evertec.edson.ui.viewModels.SignInViewModel
import com.evertec.edson.ui.views.fragments.adapters.MoviesAdapter
import com.evertec.utils.ViewManager

/**
 * Class used to load the movie list
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class MoviesFragment : Fragment() {
    private var moviesAdapter: MoviesAdapter? = null
    private val viewModel by viewModels<SignInViewModel> { getViewModelFactory() }
    private lateinit var binding: LayoutMoviesFragmentBinding

    /**
     * Method to instantiate the view
     * */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_movies_fragment, container, false)
        loadMovies()
        setAdapters()
        addSubscriptions()
        return binding.root
    }

    /**
     * Method to set adapters and load the movie list
     * */
    private fun setAdapters() {
        moviesAdapter = MoviesAdapter(ViewManager.getInstance.getCurrentActivity(), arrayListOf())
        binding.rvMovies.adapter = moviesAdapter
        binding.rvMovies.layoutManager = LinearLayoutManager(ViewManager.getInstance.getCurrentActivity())
    }

    /**
     * Method to load the movies from the view model
     * */
    private fun loadMovies() {

    }

    /**
     * Method to add subscriptions and load adapter information
     * */
    private fun addSubscriptions() {

    }
}