package io.kotest.provided

import io.kotest.core.config.AbstractProjectConfig
import io.micronaut.test.extensions.kotest.MicronautKotestExtension
import org.testcontainers.containers.PostgreSQLContainer
import java.util.Properties

object ProjectConfig : AbstractProjectConfig() {
    private val db = PostgreSQLContainer("postgres:12")
    override fun beforeAll() {
        db.start()
        System.getProperties().apply {
            setProperty("datasources.default.url", db.jdbcUrl)
            setProperty("datasources.default.username", db.username)
            setProperty("datasources.default.password", db.password)
            setProperty("r2dbc.datasources.default.url", db.jdbcUrl.replace("jdbc", "r2dbc"))
            setProperty("r2dbc.datasources.default.username", db.username)
            setProperty("r2dbc.datasources.default.password", db.password)
        }
    }

    override fun afterAll() {
        db.stop()
    }
    override fun listeners() = listOf(MicronautKotestExtension)
    override fun extensions() = listOf(MicronautKotestExtension)
}
