package dev.awilder.r2dbcDtoProjections.testEntity.service

import dev.awilder.r2dbcDtoProjections.testEntity.data.entity.TestEntity
import dev.awilder.r2dbcDtoProjections.testEntity.data.repo.TestEntityRepo
import dev.awilder.r2dbcDtoProjections.testEntity.dto.CreateTestEntityDto
import dev.awilder.r2dbcDtoProjections.testEntity.dto.EditTestEntityDto
import dev.awilder.r2dbcDtoProjections.testEntity.dto.TestEntityDto
import io.micronaut.http.annotation.Body
import jakarta.inject.Singleton
import java.util.UUID

@Singleton
class TestEntityService(
    private val testEntityRepository: TestEntityRepo
) {
    suspend fun getTestEntity(id: UUID): TestEntityDto? {
        return testEntityRepository.findDtoById(id)
    }

    suspend fun editTestEntity(id: UUID, @Body editTestEntityDto: EditTestEntityDto): TestEntityDto? {
        return testEntityRepository.editById(id, editTestEntityDto)
    }

    suspend fun createTestEntity(createTestEntityDto: CreateTestEntityDto): TestEntityDto {
        return testEntityRepository.save(
            TestEntity(
                name = createTestEntityDto.name
            )
        ).let {
            TestEntityDto(
                id = it.id,
                name = it.name
            )
        }
    }
}
