package com.evertec.repository.interfaces

import com.evertec.businessmodels.business.User

interface IDefaultUserRepository {
    fun saveDefaultUser()
    fun create(user: User)
}