import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.10"
    id("com.google.devtools.ksp") version "1.6.20-RC2-1.0.4"
}
apply {
    plugin("kotlin-kapt")
}
group = "org.example"
version = "1.0-SNAPSHOT"

/* 指名编码方式，防止编译时出现中文Error  http://t.csdn.cn/sIBmh */
tasks.withType(JavaCompile::class.java) {
    this.options.encoding = "UTF-8"
}

repositories {
    mavenCentral()
}
dependencies {
    implementation(Configuration.Dependencies.kotlin_stdlib)
    implementation(Configuration.Dependencies.kotlin_coroutine)
    implementation(Configuration.Dependencies.kotlin_reflect)
    implementation(Configuration.Dependencies.kotlinx_datetime)
}