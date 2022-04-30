package dev.awilder.r2dbcDtoProjections.testEntity.data.entity

import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import java.util.UUID

@MappedEntity
class TestEntity(
    @field:AutoPopulated
    @field:Id
    var id: UUID = UUID.randomUUID(),
    var name: String
)
