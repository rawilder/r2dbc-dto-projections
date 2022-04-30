package dev.awilder.r2dbcDtoProjections.testEntity.data.entity

import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import java.util.UUID

@MappedEntity
class TestEntity(
    var name: String
) {
    @AutoPopulated
    @field:Id
    lateinit var id: UUID
}
