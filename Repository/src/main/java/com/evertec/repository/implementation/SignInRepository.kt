package com.evertec.repository.implementation

import com.evertec.businessmodels.business.User
import com.evertec.businessmodels.request.SignInRequest
import com.evertec.businessmodels.response.SignInResponse
import com.evertec.repository.interfaces.ISignInRepository

/**
 * Class used to manage the sign in repository data and return correct information
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
open class SignInRepository : ISignInRepository {
    private val userLocalRepository = UserLocalRepository()
    override suspend fun logIn(signInRequest: SignInRequest): SignInResponse {
        return SignInResponse(
            isValid = false
        )
    }

    override suspend fun localLogIn(signInRequest: SignInRequest): SignInResponse {
        val user = User(email = signInRequest.userName, password = signInRequest.password)
        val currentUser = userLocalRepository.read(user)
        return SignInResponse(isValid = true, user = currentUser)
    }
}