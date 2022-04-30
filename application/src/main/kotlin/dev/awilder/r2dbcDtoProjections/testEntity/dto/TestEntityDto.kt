package dev.awilder.r2dbcDtoProjections.testEntity.dto

import io.micronaut.serde.annotation.Serdeable
import java.util.UUID

@Serdeable
data class TestEntityDto (
    val id: UUID,
    val name: String
)
