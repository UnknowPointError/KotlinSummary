package Util

/*
@Machine: RedmiBook Pro 15
@Author: Barry
@Time: 2022/4/2 19:27 周四
@Description: BaseUtil工具类
*/

/* 判断扩展函数 有返回值 */
inline fun <reified T> T.checkNullGetReturns(notNullResult: T.() -> T, isNullResult: T.() -> T) =
    if (this != null) notNullResult() else isNullResult()

/* 判空扩展函数 无返回值 */
inline fun <reified T> T.checkNull(notNullResult: T.() -> Unit, isNullResult: T.() -> Unit) =
    if (this != null) notNullResult() else isNullResult()
