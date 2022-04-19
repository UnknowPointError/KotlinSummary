plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.10"
    id("com.google.devtools.ksp") version "1.6.20-RC2-1.0.4"
}
group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
/* 指名编码方式，防止编译时出现中文Error  http://t.csdn.cn/sIBmh */
tasks.withType(JavaCompile::class.java) {
    this.options.encoding = "UTF-8"
}

/* 设置编译器默认参数,可以消除添加@OptIn注解后产生的警告 */
tasks.compileKotlin {
    kotlinOptions.freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn")
}

dependencies {
    implementation(Configuration.Dependencies.kotlin_stdlib)
    implementation(Configuration.Dependencies.kotlin_coroutine)
    implementation(Configuration.Dependencies.kotlin_reflect)
    implementation(Configuration.Dependencies.kotlinx_datetime)
    implementation(Configuration.Dependencies.java_rxjava3)
    implementation(Configuration.Dependencies.retrofit)
    implementation(Configuration.Dependencies.retrofit_gson)
}