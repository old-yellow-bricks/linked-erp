package com.oybricks.linkederp.domain.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

class PersonalDataDto(

    @JsonProperty("id")
    var id: Long?,

    @JsonProperty("name")
    var name: String,

    @JsonProperty("surname")
    var surName: String,

    @JsonProperty("date_of_birth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    var dateOfBirth: String,

    @JsonProperty("email_address")
    var emailAddress: String,

    @JsonProperty("phone_number")
    var phoneNumber: String,

    @JsonProperty("address")
    var address: AddressDto,

    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    var createdAt: LocalDateTime,

    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    var updatedAt: LocalDateTime,

    @JsonProperty("profile_picture_url")
    var profilePictureUrl: String
)
