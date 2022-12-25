package com.oybricks.linkederp.domain.model

import java.time.LocalDate
import java.time.LocalDateTime

class PersonalData(

    var id: Long?,

    var name: String,

    var surName: String,

    var dateOfBirth: LocalDate,

    var emailAddress: String,

    var phoneNumber: String,

    var address: Address,

    var createdAt: LocalDateTime,

    var updatedAt: LocalDateTime,

    var profilePictureUrl: String
)
