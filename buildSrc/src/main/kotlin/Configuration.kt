object Configuration {

    object Version {
        /* Kotlin 协程版本 */
        const val coroutine_version = "1.6.0"

        /* Kotlin 反射版本 */
        const val reflect_version = "1.6.10"

        /* Kotlinx 日期时间库版本*/
        const val datetime_version = "0.3.2"
    }

    object Dependencies {
        /* Kotlin 标准库依赖 */
        const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib"

        /* Kotlin 协程依赖 */
        const val kotlin_coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine_version}"

        /* Kotlin 反射依赖 */
        const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Version.reflect_version}"

        /* Kotlinx 日期时间库依赖 */
        const val kotlinx_datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Version.datetime_version}"
    }
}