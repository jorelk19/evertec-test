package com.evertec.repository.implementation

import com.evertec.businessmodels.business.User
import com.evertec.repository.RepositoryConfiguration
import com.evertec.repository.local.ILocalRepositoryManager
import com.evertec.repository.local.entities.UserDTO
import com.evertec.repository.local.mapper.LocalRepositoryUserMapper
import io.realm.Realm

class UserLocalRepository : ILocalRepositoryManager<User, UserDTO> {
    private var realm: Realm = RepositoryConfiguration.getInstance()

    override fun read(currentUser: User): User {
        val userExists = validateUserDtoExists(currentUser)
        var userBusiness = User()
        userExists?.let {
            userBusiness = LocalRepositoryUserMapper.mapUserBusiness(it)
        } ?: run { throw Exception("Los datos del usuario ingresado no existen") }
        return userBusiness
    }

    override fun removeAll(element: UserDTO) {
    }

    override fun getAll(element: UserDTO): ArrayList<User> {
        return arrayListOf()
    }

    override fun update(user: User) {
        val userExists = validateUserDtoExists(user)
        userExists?.let { currentUserDTO ->
            realm.beginTransaction()
            currentUserDTO.email = user.email
            currentUserDTO.cellPhoneNumber = user.cellPhoneNumber
            currentUserDTO.password = user.password
            currentUserDTO.firstName = user.firstName
            currentUserDTO.lastName = user.lastName
            realm.commitTransaction();
        }
    }

    private fun validateUserDtoExists(user: User) = realm.where(UserDTO::class.java).equalTo("_email", user.email).findFirst()

    override fun create(user: User) {
        val userExists = validateUserDtoExists(user)
        userExists?.let {
            throw Exception("El correo electrónico que intenta registrar ya existe")
        } ?: run {
            val index = realm.where(UserDTO::class.java).max("_id")
            val userDto = LocalRepositoryUserMapper.mapUserDTO(user)
            index?.let { num ->
                userDto.id = num.toInt() + 1
            } ?: run { userDto.id = 1 }

            realm.executeTransaction { currentRealm ->
                currentRealm.copyToRealm(userDto)
            }
        }
    }

    override fun delete(user: User) {
        val userExists = validateUserDtoExists(user)
        userExists?.let { userDto ->
            realm.executeTransaction {
                userDto.deleteFromRealm()
            }
        } ?: run {
            throw Exception("El usuario que intenta borrar no existe")
        }
    }
}
