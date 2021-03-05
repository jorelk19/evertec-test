package com.evertec.businessmodels.response

import com.evertec.businessmodels.business.Movie
import com.google.gson.annotations.SerializedName

/**
 * Class used to get the movies response from the service
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
data class MovieResponse(
    @SerializedName("results")
    val movies : ArrayList<Movie> = arrayListOf()
)
