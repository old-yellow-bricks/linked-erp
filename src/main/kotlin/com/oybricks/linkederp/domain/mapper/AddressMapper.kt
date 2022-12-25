package com.oybricks.linkederp.domain.mapper

import com.oybricks.linkederp.domain.dto.AddressDto
import com.oybricks.linkederp.domain.model.Address

object AddressMapper : MapperInterface<AddressDto, Address> {
    override fun fromEntity(entity: Address): AddressDto {
        return AddressDto(
            entity.id,
            entity.street,
            entity.complement,
            entity.neighborhood,
            entity.city,
            entity.state,
            entity.country,
            entity.zipCode,
            entity.mainAddress
        )
    }

    override fun toEntity(dto: AddressDto): Address {
        return Address(
            null,
            dto.street,
            dto.complement,
            dto.neighborhood,
            dto.city,
            dto.state,
            dto.country,
            dto.zipCode,
            dto.mainAddress
        )
    }
}
