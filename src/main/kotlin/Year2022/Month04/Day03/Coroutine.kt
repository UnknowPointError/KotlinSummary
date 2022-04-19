package Year2022.Month04.Day03

import kotlinx.coroutines.*
import java.lang.Thread.sleep
import kotlin.concurrent.thread

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/8 6:31 周五
@Description: 协程
*/

class Coroutine {

    @OptIn(DelicateCoroutinesApi::class)
    fun coroutineScope(id: Int, isNeedSleep: Boolean) {
        GlobalScope.launch {
            GlobalScope.launch(coroutineContext) {
                println("end")
            }
            delay(1000L)
            println("(id : $id) Job global coroutine.")
        }
        if (isNeedSleep) sleep(1500L)
        println("(id : $id) Exit the function named doNotBlockThread.")
    }

}

@DelicateCoroutinesApi
fun main() {
    with(Coroutine()) {
        /* ------------全局协程和非全局协程------------ */
        thread {
            coroutineScope(0, false)
        }
        /* GlobalScope用于启动顶级协程，而且这些协程会在整个应用的生命周期内运行
        （不论是在任意子线程内，只要主线程不GG，这个生命周期就会一直存在），谨慎使用避免内存泄漏。*/

        /* runBlocking是一个阻塞函数，它会在主线程中启动一个协程并等待这个协程直到它结束，*/
        runBlocking {
            coroutineScope(1, true)
        }

        /* -----------Async------------ */
        runBlocking {
            val job = launch {
                val result = async {
                    delay(1000L)
                    5 + 5
                }
                println(result.await())
            }
            launch {
                val result2 = async {
                    10 + 10
                }
                println(result2.await())
            }
        }
    }
}


