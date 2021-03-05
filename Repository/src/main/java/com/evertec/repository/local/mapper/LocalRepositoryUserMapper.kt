package com.evertec.repository.local.mapper

import com.evertec.businessmodels.business.User
import com.evertec.repository.local.entities.UserDTO

class LocalRepositoryUserMapper {
    companion object {
        fun mapUserDTO(user: User): UserDTO {
            val userDTO = UserDTO()
            userDTO.email = user.email
            userDTO.firstName = user.firstName
            userDTO.lastName = user.lastName
            userDTO.password = user.password
            userDTO.cellPhoneNumber = user.cellPhoneNumber
            return userDTO
        }

        fun mapUserBusiness(userDTO: UserDTO): User {
            return User(
                email = userDTO.email,
                firstName = userDTO.firstName,
                lastName = userDTO.lastName,
                password = userDTO.password,
                cellPhoneNumber = userDTO.cellPhoneNumber
            )
        }
    }
}