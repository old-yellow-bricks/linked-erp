package com.oybricks.linkederp.domain.mapper

import com.oybricks.linkederp.domain.dto.PersonalDataDto
import com.oybricks.linkederp.domain.model.PersonalData
import java.time.LocalDate

object PersonalDataMapper : MapperInterface<PersonalDataDto, PersonalData> {
    override fun fromEntity(entity: PersonalData): PersonalDataDto {
        val addressDto = AddressMapper.fromEntity(entity.address)
        return PersonalDataDto(
            entity.id,
            entity.name,
            entity.surName,
            entity.dateOfBirth.toString(),
            entity.emailAddress,
            entity.phoneNumber,
            addressDto,
            entity.createdAt,
            entity.updatedAt,
            entity.profilePictureUrl
        )
    }

    override fun toEntity(dto: PersonalDataDto): PersonalData {
        val addressEntity = AddressMapper.toEntity(dto.address)
        return PersonalData(
            dto.id,
            dto.name,
            dto.surName,
            LocalDate.parse(dto.dateOfBirth),
            dto.emailAddress,
            dto.phoneNumber,
            addressEntity,
            dto.createdAt,
            dto.updatedAt,
            dto.profilePictureUrl
        )
    }
}
