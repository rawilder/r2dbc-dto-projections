package dev.awilder.r2dbcDtoProjections

import io.micronaut.runtime.Micronaut.*
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

@OpenAPIDefinition(
    info = Info(
            title = "r2dbc-dto-projections-service",
            version = "0.0"
    )
)
object Api {
}
suspend fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("dev.awilder")
        .defaultEnvironments("local")
		.start()
}

