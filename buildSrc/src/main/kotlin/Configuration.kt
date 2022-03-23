object Configuration {

    object Version {
        const val coroutine_version = "1.6.0"
    }
    object Dependencies {
        const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib"
        const val kotlin_coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine_version}"
    }
}