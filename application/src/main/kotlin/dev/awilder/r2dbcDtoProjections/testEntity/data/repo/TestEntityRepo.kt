package dev.awilder.r2dbcDtoProjections.testEntity.data.repo

import dev.awilder.r2dbcDtoProjections.testEntity.data.entity.TestEntity
import dev.awilder.r2dbcDtoProjections.testEntity.dto.EditTestEntityDto
import dev.awilder.r2dbcDtoProjections.testEntity.dto.TestEntityDto
import io.micronaut.data.annotation.Query
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.r2dbc.annotation.R2dbcRepository
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID
import javax.transaction.Transactional

@R2dbcRepository(dialect = Dialect.POSTGRES)
interface TestEntityRepo : CoroutineCrudRepository<TestEntity, UUID> {
    @Query("SELECT * FROM test_entity WHERE id = :id")
    suspend fun findDtoById(id: UUID): TestEntityDto?

    @Transactional
    suspend fun editById(id: UUID, dto: EditTestEntityDto): TestEntityDto? {
        return findById(id)?.apply {
            name = dto.name
            update(this)
        }?.let {
            TestEntityDto(
                id = it.id,
                name = it.name
            )
        }
    }
}
