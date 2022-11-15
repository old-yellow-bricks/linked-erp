package com.oybricks.linkederp.domain.dto

import com.fasterxml.jackson.annotation.JsonProperty

class AddressDto(

    @JsonProperty("street")
    var street: String,

    @JsonProperty("complement")
    var complement: String,

    @JsonProperty("neighborhood")
    var neighborhood: String,

    @JsonProperty("city")
    var city: String,

    @JsonProperty("state")
    var state: String,

    @JsonProperty("country")
    var country: String,

    @JsonProperty("zip_code")
    var zipCode: String
)
