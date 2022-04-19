package Year2022.Month04.Day14__20

import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/17 11:22 周日
@Description: 
*/
val food = listOf("sandwich", "bread", "hamburger", "fried rice", "banana", "apple")

interface EatGameCallback {
    fun eat(foodName: String)
    fun feed(foodName: String)
    fun finished(foodName: String)
}

sealed class EatGameEvent
class OnFeed(val foodName: String) : EatGameEvent()
class OnEat(val foodName: String) : EatGameEvent()
class OnFinished(val foodName: String) : EatGameEvent()
class FlowCoroutineGame {

    private suspend fun startGame(callback: EatGameCallback) {
        with(food.random()) {
            callback.feed(this)
            delay(1000)
            callback.eat(this)
            delay(1000)
            callback.finished(this)
        }
    }

    fun startEatGame(): Flow<EatGameEvent> {
        return callbackFlow<EatGameEvent> {
            startGame(object : EatGameCallback {
                override fun eat(foodName: String) {
                    trySendBlocking(OnEat(foodName))
                }

                override fun feed(foodName: String) {
                    trySendBlocking(OnFeed(foodName))
                }

                override fun finished(foodName: String) {
                    trySendBlocking(OnFinished(foodName))
                    close()
                }
            })
        }
    }
}

fun interface SingleMethodCallback {
    fun onCallback(value: String)
}

fun runTask(callback: SingleMethodCallback) {
    thread {
        Thread.sleep(2000)
        callback.onCallback("runTask result.")
    }
}

suspend fun runTaskSuspend() = suspendCoroutine<String> { continuation ->
    println("开始挂起")
    runTask {
        println("resume.")
        continuation.resume(it)
    }
}

fun main() {
    val flowCoroutineGame = FlowCoroutineGame()
    runBlocking {
        launch {
            flowCoroutineGame.startEatGame().collect {
                when (it) {
                    is OnFeed -> println("OnFeed ${it.foodName}")
                    is OnEat -> println("OnEat ${it.foodName}")
                    is OnFinished -> println("OnFinished ${it.foodName}")
                }
            }
        }.join()
        launch {
            println(runTaskSuspend())
            println("End................")
        }
        launch {
            println("Three")
        }
    }

}