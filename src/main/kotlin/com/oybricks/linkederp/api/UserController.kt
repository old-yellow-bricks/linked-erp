package com.oybricks.linkederp.api

import com.oybricks.linkederp.domain.dto.UserDto
import mu.KotlinLogging
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

    @PostMapping
    private fun addUser(@RequestBody userDto: UserDto): ResponseEntity<UserDto> {
        logger.info { "Adding user" }
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto)
    }
}
