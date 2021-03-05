package com.evertec.repository.interfaces

import com.evertec.businessmodels.request.SignInRequest
import com.evertec.businessmodels.response.SignInResponse

interface ISignInRepository {
    suspend fun logIn(signInRequest : SignInRequest): SignInResponse
    suspend fun localLogIn(signInRequest : SignInRequest): SignInResponse
}