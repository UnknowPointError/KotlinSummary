package Year2022.Month04.Day10

import Util.by
import Util.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/10 21:17 周日
@Description: flow流
*/

/*
* 模型 ：
*       上游
*       操作符
*       下游
*
* */
fun main() = runBlocking<Unit> {
    val flow = flow<String> {
        for (i in 1..5) {
            delay(100)
            emit("$i")
        }
    }.collect {
        "$it\t".log(false)
    }
    "".log()
    /* ----------------- */
    flowOf(1, 2, 3, 4, 5).collect {
        delay(100)
        "$it\t".log(false)
    }
    "".log()
    /* ----------------- */
    listOf(1, 2, 3, 4, 5).asFlow().collect {
        delay(100)
        "$it\t".log(false)
    }
    "".log()
    /* ----------------- */
    val channelFlow = channelFlow<Int> {
        for (i in 1..5) {
            delay(100)
            send(i)
        }
    }.collect {
        "$it\t".log(false)
    }
    "".log()
    /* ----------------- */

    /* ---flow和channelFlow的区别--->flow */
    val flowTime = measureTimeMillis {
        flow {
            for (i in 1..5) {
                delay(100)
                emit("*" by i)
            }
        }.collect {
            delay(100)
            "$it\t".log(false)
        }
    }
    "".log()
    "cost $flowTime ms.".log()
    /* ---flow和channelFlow的区别--->channelFlow */
    val channelFlowTime = measureTimeMillis {
        channelFlow {
            for (i in 1..5) {
                delay(100)
                send("*" by i)
            }
        }.collect {
            delay(100)
            "$it\t".log(false)
        }
    }
    "".log()
    "cost $channelFlowTime ms.".log()
    /* ---flow切换线程--->flowOn */
    val flowOnTime = measureTimeMillis {
        flow {
            for (i in 1..5) {
                delay(100)
                emit("*" by i)
            }
        }.flowOn(Dispatchers.IO).collect {
            delay(100)
            "$it\t".log(false)
        }
    }
    "".log()
    "cost $flowOnTime ms.".log()
}
