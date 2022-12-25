package com.oybricks.linkederp.domain.model

import com.oybricks.linkederp.domain.enums.Role
import java.util.UUID

class User(
    var id: Long?,

    var uuid: UUID?,

    var userName: String,

    var password: String,

    var personalData: PersonalData,

    var role: Role,

    var isActive: Boolean = true
)
