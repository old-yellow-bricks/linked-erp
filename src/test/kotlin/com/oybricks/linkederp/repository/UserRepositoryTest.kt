package com.oybricks.linkederp.repository

import com.oybricks.linkederp.domain.model.PersonalData
import com.oybricks.linkederp.domain.repository.AddressRepository
import com.oybricks.linkederp.domain.repository.PersonalDataRepository
import com.oybricks.linkederp.domain.repository.UserRepository
import com.oybricks.linkederp.utils.TestUtils
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserRepositoryTest @Autowired constructor(
    private val addressRepository: AddressRepository,
    private val personalDataRepository: PersonalDataRepository,
    private val userRepository: UserRepository
) {

    lateinit var personalData: PersonalData

    @BeforeEach
    fun setup() {
        val address = addressRepository.save(TestUtils.getSomeAddressWithoutId())
        personalData = personalDataRepository.save(TestUtils.getSomePersonalDataWithoutId(), address.id!!)
    }

    @Test
    fun `should save some user with success`() {
        val user = TestUtils.getSomeUser()
        user.personalData.id = personalData.id
        val result = userRepository.save(user)
        assertNotNull(result.id)
    }
}
