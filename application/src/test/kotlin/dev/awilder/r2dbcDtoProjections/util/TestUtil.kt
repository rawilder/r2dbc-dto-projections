package dev.awilder.r2dbcDtoProjections.util

import io.micronaut.core.type.GenericArgument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.exceptions.HttpClientResponseException
import kotlinx.coroutines.reactive.awaitSingle

object TestUtil {
    suspend inline fun <reified O: Any> HttpClient.retrieveAnyObject(request: HttpRequest<out Any>): O =
        requireNotNull(exchange(request, object: GenericArgument<O>() {}).awaitSingle().body())

    suspend inline fun <reified O: Any?> HttpClient.retrieveAnyNullableObject(request: HttpRequest<out Any>): O? =
        runCatching  { exchange(request, object: GenericArgument<O>() {}).awaitSingle().body() }.fold(
            onSuccess = { it },
            onFailure = {
                when(it) {
                    is HttpClientResponseException -> {
                        if (it.status == HttpStatus.NOT_FOUND) null
                        else throw it
                    }
                    else -> throw it
                }
            }
        )
}
