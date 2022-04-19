package Year2022.Month04.Day14__20.Coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/15 13:37 周五
@Description: async
*/
fun main() = runBlocking<Unit> {
    val result = async { /* 创建一个协程 并不会立即执行 */
        delay(1000)
        5 + 5
    }
    /* async协程返回的是一个Deffered 非阻塞future */
    /* 什么是Future模式:[https://zhuanlan.zhihu.com/p/364041672] */
    /* 等待runBlockig内的作用域先先执行完后在 async协程作用域内的代码 */
    /* 调用await函数使async协程返回作用域内最后一行的结果 */
    println(result.await())
}