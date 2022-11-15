package com.oybricks.linkederp.api

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

private const val BASE_PATH = "/users"
private const val LIST_USERS_JSON = """
[
    {
        "user_id": 9999999,
        "name": "Anthony Kiedis",
        "user_name": "sir_psycho_sexy",
        "role": "ADMIN",
        "is_active": true,
        "created_at": "LocalDateTime",
        "updated_at": "LocalDateTime",
        "profile_picture_url": "String"
    }
]
"""
private const val USER_JSON = """
{
    "id": 9999999999,
    "user_name": "String",
    "password": "String",
    "personal_data": {
        "name": "String",
        "surname": "String",
        "date_of_birth": "dd/MM/yyyy",
        "email_address": "String",
        "phone_number": "String",
        "address": {
            "street": "String",
            "complement": "String",
            "neighborhood": "String",
            "city": "String",
            "state": "String",
            "country": "String",
            "zip_code": "String"
        },
        "created_at": "LocalDateTime",
        "updated_at": "LocalDateTime",
        "profile_picture_url": "String"
    },
    "role": "ADMIN",
    "is_active": true
}
"""
private const val JSON_404_ERROR = """
{
    "response_code": 404,
    "response_message: "NOT_FOUND"
}    
"""
private const val NAME = "John"
private const val USER_ID = "1"
private const val USERNAME = "sir_psycho_sexy"

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("local")
internal class UserControllerTest @Autowired constructor(
    val mockMvc: MockMvc
) {

    @Test
    fun `should save an user with success and return 201 Status`() {
        mockMvc.perform(
            post(BASE_PATH)
                .content(USER_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isCreated)
            .andExpect(content().json(USER_JSON))
    }

    @Test
    fun `should return an list of users with 200 Status`() {
        mockMvc.perform(
            get(BASE_PATH)
        )
            .andExpect(status().isOk)
            .andExpect(content().json(USER_JSON))
    }

    @Test
    fun `should find an user by name with 200 Status`() {
        mockMvc.perform(
            get(BASE_PATH)
                .queryParam(NAME)
        )
            .andExpect(status().isOk)
            .andExpect(content().json(LIST_USERS_JSON))
    }

    @Test
    fun `should find an user by ID with 200 Status`() {
        mockMvc.perform(
            get(BASE_PATH)
                .param(USER_ID)
        )
            .andExpect(status().isOk)
            .andExpect(content().json(LIST_USERS_JSON))
    }

    @Test
    fun `should find and user by userName with 200 Status`() {
        mockMvc.perform(
            get(BASE_PATH)
                .param(USERNAME)
        )
            .andExpect(status().isOk)
            .andExpect(content().json(LIST_USERS_JSON))
    }

    @Test
    fun `should deactivate an user with success and return 204 Status`() {
        mockMvc.perform(
            patch(BASE_PATH)
                .param(USER_ID)
        )
            .andExpect(status().isNoContent)
    }

    @Test
    fun `should update an user with sucesss and return updated data`() {
        mockMvc.perform(
            put(BASE_PATH)
                .param(USER_ID)
                .content(USER_JSON)
        )
            .andExpect(status().isOk)
            .andExpect(content().json(USER_JSON))
    }

    @Test
    fun `should return 404 Status when doesnt find an user`() {
        mockMvc.perform(
            get(BASE_PATH)
                .param(USER_ID)
        )
            .andExpect(status().isNotFound)
            .andExpect(content().json(JSON_404_ERROR))
    }

    @Test
    fun `should return handled exception when some error occours`() {
        // TODO
        assertEquals("1", "2")
    }

    @Test
    fun `should return error when the user type is unkknown`() {
        // TODO
        assertEquals("1", "2")
    }

    @Test
    fun `should return error when try to update some user that doesn't exists`() {
        // TODO
        assertEquals("1", "2")
    }

    @Test
    fun `should return error when try to deactivate some user that doesn't exists`() {
        // TODO
        assertEquals("1", "2")
    }

    @Test
    fun `should return error when try try to update an user with no modifications`() {
        // TODO
        assertEquals("1", "2")
    }
}
