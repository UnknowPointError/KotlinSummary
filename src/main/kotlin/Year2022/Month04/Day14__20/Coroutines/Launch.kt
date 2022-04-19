package Year2022.Month04.Day14__20.Coroutines

import kotlinx.coroutines.*

/*
@Machine: RedmiBook Pro 15
@Author: Barry
@Time: 2022/4/15 14:00 周五
@Description: launch
*/

fun main() {
    runBlocking {
        /* launch 创建一个协程作用域 */
        launch {
            println("launch one.")
        }
        val job1 = launch {
            delay(3000)
            println("launch two.")
        }
        /* 当launch one执行完后在执行 launch two*/
        /* launch 返回一个Job对象 */

        val job2: Job = launch(Dispatchers.IO) {

            delay(3100)
            val startTime = System.currentTimeMillis()
            var nextPrintTime = startTime
            var i = 0
            while (true) {
                if (!isActive) return@launch
                else {
                    val a = mutableListOf<Int>()
                    if (System.currentTimeMillis() >= nextPrintTime) {
                        println("Hello ${i++}")
                        nextPrintTime += 500L
                    } else {
                        a.add(i)
                        if (a.size > 999) a.clear()
                    }
                }
            }
        }
        job1.join() // 阻塞并等候协程完成
        println("----------开始阻塞协程----------")
        delay(1000L)
        println("Cancel!")
        delay(3000)
        job2.cancelAndJoin()// 取消并等候协程完成
        println("Done!")
        println("runBlocking End.")
    }
    println("Main End.")
}