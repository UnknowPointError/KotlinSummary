package Year2022.Month04.Day10

import kotlinx.coroutines.*

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/10 1:07 周日
@Description: 协程
*/

fun main() {
    val runBlockingResult = runBlocking {
        //yield()函数的作用是暂停当前协程，并且将协程的状态设置为挂起状态，等待其他协程执行完毕后，再恢复执行。
        val job1 = launch {
            println("job1 : 0")
            yield()
            println("job1 : 2")
        }
        val job2 = launch {
            println("job2 : 1")
            yield()
            println("job2 : end")
        }
        withContext(NonCancellable) {   //withContext并不会启动新协程，目的是让当前协程切换线程
        }
        println("runBlocking end.")
        5
    }
    println("runBlockingResult is $runBlockingResult")
    println("================================")
    runBlocking {
        val jobs = arrayListOf<Job>()
        jobs += launch(Dispatchers.Unconfined) { // 无限制
            println("Unconfiend : I'm working in thread ---> ${Thread.currentThread().name}")

        }
        jobs += launch(coroutineContext) {
            println("coroutineContext : I'm working in thread ---> ${Thread.currentThread().name}")
        }
        jobs += launch(Dispatchers.Default) {
            println("Dispatchers.Default : I'm working in thread ---> ${Thread.currentThread().name}")
        }
        jobs += launch {
            println("Default : I'm working in thread ---> ${Thread.currentThread().name}")
        }
        jobs += launch(newSingleThreadContext("MyThread")) {
            println("MyThread : I'm working in thread ---> ${Thread.currentThread().name}")
        }
    }
    println("${Thread.currentThread().name} Thread End.")
}
