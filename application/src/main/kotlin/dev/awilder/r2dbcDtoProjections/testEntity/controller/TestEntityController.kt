package dev.awilder.r2dbcDtoProjections.testEntity.controller

import dev.awilder.r2dbcDtoProjections.testEntity.dto.CreateTestEntityDto
import dev.awilder.r2dbcDtoProjections.testEntity.dto.EditTestEntityDto
import dev.awilder.r2dbcDtoProjections.testEntity.dto.TestEntityDto
import dev.awilder.r2dbcDtoProjections.testEntity.service.TestEntityService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import java.util.UUID

@Controller("/api/v1/testEntity")
class TestEntityController(
    private val testEntityService: TestEntityService
) {

    @Post
    suspend fun post(createTestEntityDto: CreateTestEntityDto): TestEntityDto {
        return testEntityService.createTestEntity(createTestEntityDto)
    }

    @Put("/{id}")
    suspend fun put(id: UUID, @Body editTestEntityDto: EditTestEntityDto): TestEntityDto? {
        return testEntityService.editTestEntity(id, editTestEntityDto)
    }

    @Get("/{id}")
    suspend fun get(id: UUID): TestEntityDto? {
        return testEntityService.getTestEntity(id)
    }
}
