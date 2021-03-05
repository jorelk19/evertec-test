package com.evertec.repository.local

import com.evertec.businessmodels.business.Movie
import io.realm.Realm

/**
 * Class used to manage the local repository
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
/*
class MovieLocalRepository : ILocalRepositoryManager<Movie, MovieDTO> {
    private var realm: Realm = Realm.getDefaultInstance()
    override fun update(element: Movie) {
    }

    override fun create(movie: Movie) {
        val index = realm.where(MovieDTO::class.java).max("_id")
        val movieDto = LocalRepositoryMovieMapper.mapMovieDTO(movie)
        index?.let { num ->
            movieDto.id = num.toInt() + 1
        } ?: run { movieDto.id = 1 }

        realm.executeTransaction { currentRealm ->
            currentRealm.copyToRealm(movieDto)
        }
    }

    override fun delete(element: Movie) {
    }

    override fun read(element: MovieDTO): Movie {
        return Movie()
    }

    override fun removeAll(movieDTOType: MovieDTO) {
        val movieDTO = realm.where(movieDTOType::class.java).findAll()
        realm.executeTransaction {
            movieDTO.deleteAllFromRealm()
        }
    }

    override fun getAll(element: MovieDTO) :ArrayList<Movie> {
        val movies = ArrayList<Movie>()
        val moviesDto = realm.where(MovieDTO::class.java).findAll()
        moviesDto?.let { movieDTOResults ->
            movieDTOResults.forEach {
                movies.add(LocalRepositoryMovieMapper.mapMovieBusiness(it))
            }
        }
        return  movies
    }
}

*/
