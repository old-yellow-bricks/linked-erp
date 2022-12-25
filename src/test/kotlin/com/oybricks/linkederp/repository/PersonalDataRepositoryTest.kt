package com.oybricks.linkederp.repository

import com.oybricks.linkederp.domain.model.Address
import com.oybricks.linkederp.domain.repository.AddressRepository
import com.oybricks.linkederp.domain.repository.PersonalDataRepository
import com.oybricks.linkederp.utils.TestUtils
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PersonalDataRepositoryTest @Autowired constructor(
    private val personalDataRepository: PersonalDataRepository,
    private val addressRepository: AddressRepository
) {

    lateinit var address: Address
    var addressId: Long = 0

    @BeforeEach
    fun setup() {
        address = addressRepository.save(TestUtils.getSomeAddressWithoutId())
        addressId = address.id!!
    }

    @Test
    fun `should save a personal data with success and return id`() {
        val result = personalDataRepository.save(TestUtils.getSomePersonalDataWithoutId(), addressId)
        assertNotNull(result.id)
    }
}
