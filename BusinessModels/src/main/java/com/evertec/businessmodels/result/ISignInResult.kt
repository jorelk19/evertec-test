package com.evertec.businessmodels.result

import com.evertec.businessmodels.response.SignInResponse

interface ISignInResult {
    fun logIn(signInResponse: SignInResponse)
}