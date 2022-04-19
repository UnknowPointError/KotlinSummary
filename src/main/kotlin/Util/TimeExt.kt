package Util

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.util.*

/*
@Machine: RedmiBook Pro 15
@Author: Barry
@Time: 2022/3/22 19:44 周二
@Description: TimeUtil工具类
*/
object ago
object later

val Int.nanoseconds: Duration
    get() = Duration.ofNanos(toLong())

val Int.microseconds: Duration
    get() = Duration.ofNanos(toLong() * 1000L)

val Int.milliseconds: Duration
    get() = Duration.ofMillis(toLong())

val Int.seconds: Duration
    get() = Duration.ofSeconds(toLong())

val Int.minutes: Duration
    get() = Duration.ofMinutes(toLong())

val Int.hours: Duration
    get() = Duration.ofHours(toLong())

val Int.days: Period
    get() = Period.ofDays(this)

val Int.weeks: Period
    get() = Period.ofWeeks(this)

val Int.months: Period
    get() = Period.ofMonths(this)

val Int.years: Period
    get() = Period.ofYears(this)

val Duration.ago: LocalDateTime
    get() = LocalDateTime.now() - this

val Duration.later: LocalDateTime
    get() = LocalDateTime.now() + this

val Period.ago: LocalDate
    get() = LocalDate.now() - this

val Period.later: LocalDate
    get() = LocalDate.now() + this

infix fun Int.nanoseconds(later: later): LocalDateTime = LocalDateTime.now().plusNanos(toLong())
infix fun Int.nanoseconds(ago: ago): LocalDateTime = LocalDateTime.now().minusNanos(toLong())
infix fun Int.microseconds(later: later): LocalDateTime = LocalDateTime.now().plusNanos(1000L * toLong())
infix fun Int.microseconds(ago: ago): LocalDateTime = LocalDateTime.now().minusNanos(1000L * toLong())
infix fun Int.milliseconds(later: later): LocalDateTime = LocalDateTime.now().plusNanos(1000000L * toLong())
infix fun Int.milliseconds(ago: ago): LocalDateTime = LocalDateTime.now().minusNanos(1000000L * toLong())
infix fun Int.seconds(later: later): LocalDateTime = LocalDateTime.now().plusSeconds(toLong())
infix fun Int.seconds(ago: ago): LocalDateTime = LocalDateTime.now().minusSeconds(toLong())
infix fun Int.minutes(later: later): LocalDateTime = LocalDateTime.now().plusMinutes(toLong())
infix fun Int.minutes(ago: ago): LocalDateTime = LocalDateTime.now().minusMinutes(toLong())
infix fun Int.hours(later: later): LocalDateTime = LocalDateTime.now().plusHours(toLong())
infix fun Int.hours(ago: ago): LocalDateTime = LocalDateTime.now().minusHours(toLong())
infix fun Int.days(later: later): LocalDate = LocalDate.now().plusDays(toLong())
infix fun Int.days(ago: ago): LocalDate = LocalDate.now().minusDays(toLong())
infix fun Int.weeks(later: later): LocalDate = LocalDate.now().plusWeeks(toLong())
infix fun Int.weeks(ago: ago): LocalDate = LocalDate.now().minusWeeks(toLong())
infix fun Int.months(later: later): LocalDate = LocalDate.now().plusMonths(toLong())
infix fun Int.months(ago: ago): LocalDate = LocalDate.now().minusMonths(toLong())
infix fun Int.years(later: later): LocalDate = LocalDate.now().plusYears(toLong())
infix fun Int.years(ago: ago): LocalDate = LocalDate.now().minusYears(toLong())

/* 获取时间 */
fun getTime(): String = LocalDateTime.now().run { "${year}年${month.value}月${dayOfMonth}日${hour}时${minute}分" }

/* 将时间戳转换为时间 */
fun timeStampToDate(timeStamp: Long): String? = SimpleDateFormat("YYYY-MM-dd-HH:mm ss : aa").format(Date(timeStamp * 1000))