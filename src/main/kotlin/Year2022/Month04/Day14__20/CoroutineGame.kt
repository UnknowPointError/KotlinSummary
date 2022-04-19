package Year2022.Month04.Day14__20

import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.reflect.KMutableProperty0

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/14 2:05 周四
@Description: 协程挂起案例
*/

class CoroutineGame {

    private var feedContinuation: Continuation<Int>? = null
    private var eatContinuation: Continuation<String>? = null
    private var eatAttempts = 0

    private var isActive: Boolean = true
        private set

    private suspend fun eat(): String {
        return if (isActive) suspendCoroutine {
            eatContinuation = it
            resumeContinuation<Int>(this::feedContinuation, eatAttempts++)
        } else ""
    }

    private suspend fun feed(food: String): Int {
        return if (isActive) suspendCoroutine {
            feedContinuation = it
            resumeContinuation<String>(this::eatContinuation, food)
        } else -1
    }

    private fun <T> resumeContinuation(
        continuationRef: KMutableProperty0<Continuation<T>?>,
        value: T
    ) {
        val continuation = continuationRef.get()
        continuationRef.set(null)
        continuation?.resume(value)

    }

    private fun timeout() {
        isActive = false
        resumeContinuation(this::feedContinuation, -1)
        resumeContinuation(this::eatContinuation, "")
    }

    fun eatGame() = runBlocking {
        coroutineScope {
            val dispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
            launch(dispatcher) {
                println("Ready Go!")
                timeout()
                delay(500)
                println("TimeOut!")
            }
            launch(dispatcher) {
                while (this@CoroutineGame.isActive) {
                    println("feed run.")
                    delay(100)
                    val food = Math.random()
                    println("[${Thread.currentThread().name} --> 1] Feed : $food >>>")
                    println("[${Thread.currentThread().name} --> 3] Complete : ${feed(food.toString())}")
                }
            }
            launch(dispatcher) {
                while (this@CoroutineGame.isActive) {
                    println("eat run.")
                    delay(50)
                    println("[${Thread.currentThread().name} --> 2] eat : ${eat()}")
                }
            }
        }
    }

}

fun main() {
    CoroutineGame().eatGame()
}
/*
* 执行流程：
* 协程挂起案例. 通过suspendCoroutine挂起协程，并通过resumeContinuation恢复协程
* 并吧挂起的协程上下文存入到Continuation中，并通过Continuation的resume恢复协程
* */


