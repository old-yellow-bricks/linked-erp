package com.oybricks.linkederp.repository

import com.oybricks.linkederp.domain.repository.AddressRepository
import com.oybricks.linkederp.utils.TestUtils
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AddressRepositoryTest @Autowired constructor(
    private val addressRepository: AddressRepository
) {
    @Test
    fun `should save some address with success and return with ID`() {
        val result = addressRepository.save(TestUtils.getSomeAddressWithoutId())
        assertNotNull(result.id)
    }

    @Test
    fun `should update some address and return the new address`() {}

    @Test
    fun `should get the address with success`() {}

    @Test
    fun `should delete some address with success`() {}
}
