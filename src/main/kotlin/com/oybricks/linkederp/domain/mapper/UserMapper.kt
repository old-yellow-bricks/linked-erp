package com.oybricks.linkederp.domain.mapper

import com.oybricks.linkederp.domain.dto.UserDto
import com.oybricks.linkederp.domain.model.User

class UserMapper : MapperInterface<UserDto, User> {
    override fun fromEntity(entity: User): UserDto {
        val personalData = PersonalDataMapper.fromEntity(entity.personalData)
        return UserDto(
            entity.id,
            entity.uuid,
            entity.userName,
            entity.password,
            personalData,
            entity.role,
            entity.isActive
        )
    }

    override fun toEntity(dto: UserDto): User {
        val personalData = PersonalDataMapper.toEntity(dto.personalDataDto)
        return User(
            dto.id,
            dto.uuid,
            dto.userName,
            dto.password,
            personalData,
            dto.role,
            dto.isActive
        )
    }
}
