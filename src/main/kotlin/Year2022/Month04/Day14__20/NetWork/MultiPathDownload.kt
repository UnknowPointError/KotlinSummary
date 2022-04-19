package Year2022.Month04.Day14__20.NetWork

import io.reactivex.rxjava3.functions.Cancellable
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/17 8:42 周日
@Description: 多路径下载
*/

class MultiPathDownload {

    private fun startTask(callback: MultiPathsCallback<String>): Cancellable {
        val thread = thread {
            try {
                (0..10).forEach {
                    Thread.sleep(10)
                    callback.onProgress(it)
                }
                callback.onResult("Done.")
                callback.onComplete()

            } catch (e: Exception) {
                callback.onError(e)
            }
        }
        return Cancellable {
            println("thread interrupt.")
            thread.interrupt()
        }

    }

    fun startTaskAsFlow() = callbackFlow {
        val cancellable = startTask(object : MultiPathsCallback<String> {
            override fun onProgress(value: Int) {
                trySendBlocking(OnProgress(value))
            }

            override fun onResult(value: String) {
                trySendBlocking(OnResult(value))
            }

            override fun onError(throwable: Throwable) {
                trySendBlocking(OnError(throwable))
                close()
            }

            override fun onComplete() {
                trySendBlocking(OnComplete)
                close()
            }
        })
        awaitClose {
            cancellable.cancel()
        }
    }.conflate()
}

fun main() {
    runBlocking {
        val download = MultiPathDownload()
        launch {
            download.startTaskAsFlow().collect {
                when (it) {
                    OnComplete -> println("Done.")
                    is OnError -> println("Error ${it.throwable}")
                    is OnProgress -> println("Progress ${it.value}")
                    is OnResult<*> -> println("Result is ${it.value}")
                }
            }
        }
        println("RunBlocking End.")
    }
}

