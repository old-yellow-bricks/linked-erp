package com.oybricks.linkederp.domain.service

import com.oybricks.linkederp.domain.model.User

interface UserService {

    fun addUser(user: User): User
//    fun updateUser(user: User, id: Long): User
//    fun getAllUsers(): List<User>
//    fun getUserById(id: Long): User
//    fun getUserByName(name: String): List<User>
//    fun getUserByUserName(userName: String): List<User>
//    fun activateDeactivateUser(id: Long, operation: Boolean)
}
