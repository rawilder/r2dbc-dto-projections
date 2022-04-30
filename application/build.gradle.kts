plugins {
    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.allopen")
    id("io.micronaut.application")
}

version = "0.1"
group = "dev.awilder"

repositories {
    mavenCentral()
}

dependencies {
    kapt(Micronaut.Annotations.micronautHttpValidation)
    kapt(Micronaut.Annotations.micronautDataProcessor)
    kapt(Micronaut.Annotations.micronautOpenapi)
    kapt(Micronaut.Annotations.micronautSecurityAnnotations)
    kapt(Micronaut.Annotations.micronautSerdeProcessor)
    implementation(Micronaut.micronautHttpClient)
    implementation(Micronaut.micronautManagement)
    implementation(Micronaut.micronautRuntime)
    implementation(Micronaut.micronautCacheCaffeine)
    implementation(Micronaut.micronautDataR2dbc)
    runtimeOnly(Micronaut.micronautJdbcHikari)
    implementation(Micronaut.micronautFlyway)
    implementation(Micronaut.micronautKotlinExtensionFunctions)
    implementation(Micronaut.micronautKotlinRuntime)
    implementation(Micronaut.micronautMicrometerCore)
    implementation(Micronaut.micronautMicrometerRegistryNewRelic)
    implementation(Micronaut.micronautReactor)
    implementation(Micronaut.micronautReactorHttpClient)
    implementation(Micronaut.micronautSecurity)
    implementation(Micronaut.micronautSecurityOauth2)
    implementation(Micronaut.micronautSerdeJackson)
    implementation(Misc.swaggerAnnotations)
    implementation(Misc.jakartaAnnotationApi)
    implementation(Kotlin.kotlinStdlib)
    implementation(Kotlin.kotlinReflect)
    implementation(Kotlin.kotlinCoroutines)
    implementation(Kotlin.kotlinCoroutinesReactive)
    runtimeOnly(Misc.logbackClassic)
    runtimeOnly(Db.r2dbcPostgresql)
    runtimeOnly(Db.postgresql)
    testImplementation(Testcontainers.r2dbc)
    testImplementation(Testcontainers.testcontainers)
    testImplementation(Testcontainers.postgres)
    implementation(Micronaut.micronautValidation)

    runtimeOnly(Misc.jacksonRuntime)
}


application {
    mainClass.set("dev.awilder.r2dbcDtoProjections.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    test {
        testLogging {
            events("passed", "skipped", "failed")
            showStackTraces = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }

    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("kotest")
    processing {
        incremental(true)
        annotations("dev.awilder.*")
    }
}


