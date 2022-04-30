import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version Versions.kotlinVersion apply false
    kotlin("kapt") version Versions.kotlinVersion apply false
    kotlin("plugin.allopen") version Versions.kotlinVersion apply false
    kotlin("plugin.noarg") version Versions.kotlinVersion apply false
    id("io.micronaut.application") version Versions.micronautPlugin apply false
    id("io.micronaut.library") version Versions.micronautPlugin apply false
}

buildscript {
    repositories {
        mavenCentral()
    }
}

allprojects {
    group = "dev.awilder"
    version = "0.1"

    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_11.toString()
        targetCompatibility = JavaVersion.VERSION_11.toString()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs =
                freeCompilerArgs + "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi,kotlinx.coroutines.FlowPreview,kotlin.time.ExperimentalTime" + "-Xjvm-default=all"
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
}

subprojects {
    repositories {
        mavenCentral()
    }
}
