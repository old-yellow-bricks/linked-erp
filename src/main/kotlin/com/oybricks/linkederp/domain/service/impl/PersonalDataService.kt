package com.oybricks.linkederp.domain.service.impl

import com.oybricks.linkederp.domain.model.Address
import com.oybricks.linkederp.domain.model.PersonalData
import com.oybricks.linkederp.domain.repository.PersonalDataRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonalDataService @Autowired constructor(
    private val personalDataRepository: PersonalDataRepository
) {

    fun save(personalData: PersonalData) {
        personalDataRepository.save(personalData, personalData.address.id!!)
    }
}
