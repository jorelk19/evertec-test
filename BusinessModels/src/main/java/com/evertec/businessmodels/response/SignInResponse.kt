package com.evertec.businessmodels.response

import com.evertec.businessmodels.business.User

data class SignInResponse(
    val isValid: Boolean = false,
    val user: User = User()
)