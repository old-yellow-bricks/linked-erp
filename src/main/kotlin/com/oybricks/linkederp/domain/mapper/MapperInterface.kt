package com.oybricks.linkederp.domain.mapper

interface MapperInterface<D, E> {

    fun fromEntity(entity: E): D

    fun toEntity(dto: D): E
}
