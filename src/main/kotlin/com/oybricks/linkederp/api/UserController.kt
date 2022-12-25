package com.oybricks.linkederp.api

import com.oybricks.linkederp.domain.dto.UserDto
import com.oybricks.linkederp.domain.mapper.UserMapper
import com.oybricks.linkederp.domain.service.UserService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("users")
class UserController {

    @Autowired
    lateinit var userService: UserService

    var userMapper = UserMapper()

    @PostMapping
    private fun addUser(@RequestBody userDto: UserDto): ResponseEntity<UserDto> {
        logger.debug { "[Controller] - Saving user..." }
        val userCreated = userService.addUser(userMapper.toEntity(userDto))
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.fromEntity(userCreated))
    }
}
