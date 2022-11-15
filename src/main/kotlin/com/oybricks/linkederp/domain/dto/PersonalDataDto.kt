package com.oybricks.linkederp.domain.dto

import com.fasterxml.jackson.annotation.JsonProperty

class PersonalDataDto(

    @JsonProperty("name")
    var name: String,

    @JsonProperty("surname")
    var surName: String,

    @JsonProperty("date_of_birth")
    var dateOfBirth: String,

    @JsonProperty("email_address")
    var emailAddress: String,

    @JsonProperty("phone_number")
    var phoneNumber: String,

    @JsonProperty("address")
    var address: AddressDto,

    @JsonProperty("created_at")
    var createdAt: String,

    @JsonProperty("updated_at")
    var updatedAt: String,

    @JsonProperty("profile_picture_url")
    var profilePictureUrl: String
)
