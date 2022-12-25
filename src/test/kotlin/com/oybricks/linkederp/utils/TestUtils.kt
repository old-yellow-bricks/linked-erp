package com.oybricks.linkederp.utils

import com.oybricks.linkederp.domain.enums.Role
import com.oybricks.linkederp.domain.model.Address
import com.oybricks.linkederp.domain.model.PersonalData
import com.oybricks.linkederp.domain.model.User
import java.time.LocalDate
import java.time.LocalDateTime

object TestUtils {

    fun getSomeAddressWithoutId(): Address {
        return Address(
            null,
            "Infinita Highway",
            "BR-101",
            "10000 Destinos",
            "Porto Alegre",
            "RS",
            "Brasil",
            "99999-999",
            true
        )
    }

    fun getSomeAddressWithId(): Address {
        return Address(
            1L,
            "Infinita Highway",
            "BR-101",
            "10000 Destinos",
            "Porto Alegre",
            "RS",
            "Brasil",
            "99999-999",
            true
        )
    }

    fun getSomePersonalDataWithoutId(): PersonalData {
        return PersonalData(
            null,
            "Amora",
            "Mariléia",
            LocalDate.parse("2021-08-25"),
            "amora@marileia.net",
            "+5511999999999",
            getSomeAddressWithId(),
            LocalDateTime.now(),
            LocalDateTime.now(),
            "www.google.com/profile-picture.jpg"
        )
    }

    fun getSomeUser(): User {
        return User(
            null,
            null,
            "sikamikaniko",
            "password",
            getSomePersonalDataWithoutId(),
            Role.ADMIN,
            true
        )
    }
}
