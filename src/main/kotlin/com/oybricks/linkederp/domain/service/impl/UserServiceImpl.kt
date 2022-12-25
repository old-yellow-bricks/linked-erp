package com.oybricks.linkederp.domain.service.impl

import com.oybricks.linkederp.domain.model.User
import com.oybricks.linkederp.domain.repository.UserRepository
import com.oybricks.linkederp.domain.service.UserService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class UserServiceImpl @Autowired constructor(
    private val addressService: AddressService,
    private val personalDataService: PersonalDataService
) : UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    override fun addUser(user: User): User {
        logger.debug { "[UserService] - Saving address..." }
        addressService.save(user.personalData.address)

        logger.debug { "[UserService] - Saving personal data..." }
        personalDataService.save(user.personalData)

        logger.debug { "[UserService] - Saving user..." }
        return userRepository.save(user)
    }
//
//    override fun updateUser(user: User, id: Long): User {
//        return userRepository.update(id, user)
//    }
//
//    override fun getAllUsers(): List<User> {
//        return userRepository.getAll()
//    }
//
//    override fun getUserById(id: Long): User {
//        return userRepository.findById(id)
//    }
//
//    override fun getUserByName(name: String): List<User> {
//        return userRepository.findByName(name)
//    }
//
//    override fun getUserByUserName(userName: String): List<User> {
//        return userRepository.findByUserName(userName)
//    }
//
//    override fun activateDeactivateUser(id: Long, operation: Boolean) {
//        userRepository.activateDeactivateUser(id, operation)
//    }
}
