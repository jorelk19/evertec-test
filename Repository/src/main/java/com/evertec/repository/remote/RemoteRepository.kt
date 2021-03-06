package com.evertec.repository.remote

import com.evertec.businessmodels.api.SignInApi
import com.evertec.businessmodels.response.SignInResponse

/**
 * Class used to load remote movie information
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class RemoteRepository(private val signInApi: SignInApi) {
    suspend fun getRemoteMovies(): SignInResponse {
        return signInApi.signIn()
    }
}