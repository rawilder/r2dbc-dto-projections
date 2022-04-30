package dev.awilder.r2dbcDtoProjections.testEntity

import dev.awilder.r2dbcDtoProjections.util.TestUtil.retrieveAnyObject
import dev.awilder.r2dbcDtoProjections.testEntity.dto.TestEntityDto
import dev.awilder.r2dbcDtoProjections.util.TestUtil.retrieveAnyNullableObject
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import java.util.UUID

@MicronautTest
class TestEntityTest(
    @Client("/")
    private val client: HttpClient
): StringSpec({

    lateinit var testEntityId: UUID
    "create a testentity returns data" {
        val id = client.retrieveAnyObject<TestEntityDto>(HttpRequest.POST(
            "/api/v1/testEntity",
            """
            {
                "name": "test"
            }
            """.trimIndent()
        )).also { testEntityDto ->
            testEntityDto should {
                it.name shouldBe "test"
            }
        }.id
        testEntityId = id
        client.retrieveAnyNullableObject<TestEntityDto?>(HttpRequest.GET("/api/v1/testEntity/$id")) should {
            it.shouldNotBeNull()
            it.name shouldBe "test"
        }
    }

    "edit a testentity returns successfully" {
        client.retrieveAnyNullableObject<TestEntityDto?>(HttpRequest.PUT(
            "/api/v1/testEntity/$testEntityId",
            """
            {
                "name": "test2"
            }
           """.trimIndent()
        )).also { testEntityDto ->
            testEntityDto should {
                it.shouldNotBeNull()
                it.name shouldBe "test2"
            }
        }
    }

    "get a testentity that doesn't exist returns null" {
        client.retrieveAnyNullableObject<TestEntityDto?>(HttpRequest.GET("/api/v1/testEntity/${UUID.randomUUID()}")) shouldBe null
    }

    "edit a testentity that doesn't exist returns null" {
        client.retrieveAnyNullableObject<TestEntityDto?>(HttpRequest.PUT(
            "/api/v1/testEntity/${UUID.randomUUID()}",
            """
            {
                "name": "Doesn't Exist"
            }
           """.trimIndent()

        )) shouldBe null
    }
})
