/**
 * You may wonder, "hey, why are many of these dependencies unversioned?"
 * Good question!
 * 1. The micronaut library plugin
 *    (https://github.com/micronaut-projects/micronaut-gradle-plugin#micronaut-library-plugin)
 *    provides the Micronaut Bill of Materials (BOM). Note that this plugin is also used in the micronaut application
 *    plugin.
 * 2. The BOM (https://search.maven.org/artifact/io.micronaut/micronaut-bom/2.5.7/pom)
 *    specifies exactly what versions of specific things work with Micronaut.
 * 3. Think less, smile more.
 */

object Versions {
    // This version is necessary for plugins - plugins are sourced before micronaut-bom is sourced.
    // We may run into issues if this Kotlin version doesn't match the bom's configured Kotlin version.
    // Incidentally...we have done that. 1.5.20 is ahead of Micronaut's BOM.
    const val kotlinVersion = "1.6.20"
    const val mavenSettingsPlugin = "0.5"
    const val micronautPlugin = "3.3.2"
}

object Db {
    const val r2dbcPostgresql = "io.r2dbc:r2dbc-postgresql"
    const val postgresql = "org.postgresql:postgresql"
}

object Kotlin {
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect"
    const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core"
    const val kotlinCoroutinesReactive = "org.jetbrains.kotlinx:kotlinx-coroutines-reactive"
}

object Micronaut {
    // See gradle.properties for micronautVersion.
    object Annotations {
        const val micronautHttpValidation = "io.micronaut:micronaut-http-validation"
        const val micronautDataProcessor = "io.micronaut.data:micronaut-data-processor"
        const val micronautOpenapi = "io.micronaut.openapi:micronaut-openapi"
        const val micronautSecurityAnnotations = "io.micronaut.security:micronaut-security-annotations"
        const val micronautSerdeProcessor = "io.micronaut.serde:micronaut-serde-processor"
    }
    const val micronautHttpClient = "io.micronaut:micronaut-http-client"
    const val micronautManagement = "io.micronaut:micronaut-management"
    const val micronautRuntime = "io.micronaut:micronaut-runtime"
    const val micronautCacheCaffeine = "io.micronaut.cache:micronaut-cache-caffeine"
    const val micronautDataR2dbc = "io.micronaut.data:micronaut-data-r2dbc"
    const val micronautJdbcHikari = "io.micronaut.sql:micronaut-jdbc-hikari"
    const val micronautFlyway = "io.micronaut.flyway:micronaut-flyway"
    const val micronautKotlinExtensionFunctions = "io.micronaut.kotlin:micronaut-kotlin-extension-functions"
    const val micronautKotlinRuntime = "io.micronaut.kotlin:micronaut-kotlin-runtime"
    const val micronautMicrometerCore = "io.micronaut.micrometer:micronaut-micrometer-core"
    const val micronautMicrometerRegistryNewRelic = "io.micronaut.micrometer:micronaut-micrometer-registry-new-relic"
    const val micronautReactor = "io.micronaut.reactor:micronaut-reactor"
    const val micronautReactorHttpClient = "io.micronaut.reactor:micronaut-reactor-http-client"
    const val micronautSecurity = "io.micronaut.security:micronaut-security"
    const val micronautSecurityOauth2 = "io.micronaut.security:micronaut-security-oauth2"
    const val micronautSerdeJackson = "io.micronaut.serde:micronaut-serde-jackson"
    const val micronautValidation = "io.micronaut:micronaut-validation"
}

object Testcontainers {
    const val testcontainers = "org.testcontainers:testcontainers"
    const val postgres = "org.testcontainers:postgresql"
    const val r2dbc = "org.testcontainers:r2dbc"
}

object Misc {
    const val swaggerAnnotations = "io.swagger.core.v3:swagger-annotations"
    const val jakartaAnnotationApi = "jakarta.annotation:jakarta.annotation-api"
    const val logbackClassic = "ch.qos.logback:logback-classic"
    const val jacksonRuntime = "com.fasterxml.jackson.module:jackson-module-kotlin"
}
