package com.oybricks.linkederp.api

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
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
private const val USER_JSON = """
{
    "user_name": "dinossauro",
    "password": "vemmeteoro@123",
    "personal_data": {
        "name": "Dino",
        "surname": "Silva Sauro",
        "date_of_birth": "1993-02-10",
        "email_address": "some@email.com",
        "phone_number": "+5511999999999",
        "address": {
            "street": "Rua das Abobrinhas",
            "complement": "APTO 155 BL Z",
            "neighborhood": "Centro",
            "city": "São Paulo",
            "state": "São Paulo",
            "country": "Brasil",
            "zip_code": "99999-999"
        },
        "created_at": "2022-12-19 08:14",
        "updated_at": "2022-12-19 08:14",
        "profile_picture_url": "String"
    },
    "role": "ADMIN",
    "is_active": true
}
"""
private const val JSON_404_ERROR = """
{
    "response_code": 404,
    "response_message": "NOT_FOUND"
}    
"""
private val USER_LIST = listOf(USER_JSON)
private const val NAME = "Dino"
private const val USER_ID = "1"
private const val USERNAME = "dinossauro"

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
    }

    @Disabled
    @Test
    fun `should return an list of users with 200 Status`() {
        mockMvc.perform(
            get(BASE_PATH)
        )
            .andExpect(status().isOk)
            .andExpect(content().json(USER_JSON))
    }

    @Disabled
    @Test
    fun `should find an user by name with 200 Status`() {
        mockMvc.perform(
            get(BASE_PATH)
                .queryParam(NAME)
        )
            .andExpect(status().isOk)
            .andExpect(content().json(USER_LIST.toString()))
    }

    @Disabled
    @Test
    fun `should find an user by ID with 200 Status`() {
        mockMvc.perform(
            get(BASE_PATH)
                .param(USER_ID)
        )
            .andExpect(status().isOk)
            .andExpect(content().json(USER_LIST.toString()))
    }

    @Disabled
    @Test
    fun `should find and user by userName with 200 Status`() {
        mockMvc.perform(
            get(BASE_PATH)
                .param(USERNAME)
        )
            .andExpect(status().isOk)
            .andExpect(content().json(USER_LIST.toString()))
    }

    @Disabled
    @Test
    fun `should deactivate an user with success and return 204 Status`() {
        mockMvc.perform(
            patch(BASE_PATH)
                .param(USER_ID)
        )
            .andExpect(status().isNoContent)
    }

    @Disabled
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

    @Disabled
    @Test
    fun `should return 404 Status when doesnt find an user`() {
        mockMvc.perform(
            get(BASE_PATH)
                .param(USER_ID)
        )
            .andExpect(status().isNotFound)
            .andExpect(content().json(JSON_404_ERROR))
    }

    @Disabled
    @Test
    fun `should return handled exception when some error occours`() {
        // TODO
        assertEquals("1", "2")
    }

    @Disabled
    @Test
    fun `should return error when the user type is unkknown`() {
        // TODO
        assertEquals("1", "2")
    }

    @Disabled
    @Test
    fun `should return error when try to update some user that doesn't exists`() {
        // TODO
        assertEquals("1", "2")
    }

    @Disabled
    @Test
    fun `should return error when try to deactivate some user that doesn't exists`() {
        // TODO
        assertEquals("1", "2")
    }

    @Disabled
    @Test
    fun `should return error when try try to update an user with no modifications`() {
        // TODO
        assertEquals("1", "2")
    }
}
