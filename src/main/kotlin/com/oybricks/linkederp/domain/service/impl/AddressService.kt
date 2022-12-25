package com.oybricks.linkederp.domain.service.impl

import com.oybricks.linkederp.domain.model.Address
import com.oybricks.linkederp.domain.repository.AddressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AddressService @Autowired constructor(
    private val addressRepository: AddressRepository
) {

    fun save(address: Address): Address {
        addressRepository.save(address)
        return address
    }

    // todo: update
    // todo: get by id
    // todo: get by id list
    // todo: delete
    // todo: check in some api if the zipcode is valid
}
