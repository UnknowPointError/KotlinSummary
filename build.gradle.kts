plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.10-RC"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(Configuration.Dependencies.kotlin_stdlib)
    implementation(Configuration.Dependencies.kotlin_coroutine)
}