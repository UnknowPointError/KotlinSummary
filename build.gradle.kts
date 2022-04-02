plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(Configuration.Dependencies.kotlin_stdlib)
    implementation(Configuration.Dependencies.kotlin_coroutine)
    implementation(Configuration.Dependencies.kotlin_reflect)
    implementation(Configuration.Dependencies.kotlinx_datetime)
}