package com.oybricks.linkederp.domain.model

class Address(

    var id: Long?,

    var street: String,

    var complement: String,

    var neighborhood: String,

    var city: String,

    var state: String,

    var country: String,

    var zipCode: String,

    val mainAddress: Boolean
)
