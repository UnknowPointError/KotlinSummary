package Util

/*
@Machine: RedmiBook Pro 15
@Author: Barry
@Time: 2022/4/2 19:27 周四
@Description: BaseUtil工具类
*/

fun Any.log(newLine: Boolean = true) = if (newLine) println(this) else print(this)

infix fun String.by(number: Int): String {
    var str = ""
    repeat(number) { str += this }
    return str
}