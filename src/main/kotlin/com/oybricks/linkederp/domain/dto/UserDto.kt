package com.oybricks.linkederp.domain.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.oybricks.linkederp.domain.enums.Role
import java.util.UUID

class UserDto(

    @JsonProperty("id")
    var id: Long?,

    @JsonProperty("uuid")
    var uuid: UUID?,

    @JsonProperty("user_name")
    var userName: String,

    @JsonProperty("password")
    var password: String,

    @JsonProperty("personal_data")
    var personalDataDto: PersonalDataDto,

    @JsonProperty("role")
    var role: Role,

    @JsonProperty("is_active")
    var isActive: Boolean = true
)
