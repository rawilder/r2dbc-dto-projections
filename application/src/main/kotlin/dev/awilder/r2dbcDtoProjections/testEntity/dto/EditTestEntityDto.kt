package dev.awilder.r2dbcDtoProjections.testEntity.dto

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class EditTestEntityDto(
    val name: String
)
