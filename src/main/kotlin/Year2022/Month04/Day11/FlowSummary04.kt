package Year2022.Month04.Day11

import Util.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/12 1:12 周二
@Description: 并行操作
*/

class FlowSummary04 {
    suspend fun requestFlow(i: Int): Flow<String> = flow {
        println("requestFlow start")
        emit("$i: First")
        println("requestFlow Running.")
        delay(100) // wait 500 ms
        emit("$i: Second")
        println("requestFlow End.")
    }
}

@FlowPreview
fun main() = runBlocking<Unit> {
    val result = arrayListOf<Int>()
    for (index in 1..100) {
        result.add(index)
    }
    result.asFlow().flatMapMerge {
        flow { emit(it) }.flowOn(Dispatchers.IO)
    }

        .collect { "$it".log() }
    // flatMapMerge的作用  将一个流中的每个元素都转换为一个流，然后将这些流合并成一个流
    /* ---------------------- */
    "---------------------".log()
    with(FlowSummary04()) {
        val time = measureTimeMillis {
            val flow = (1..32).asFlow()
            val flowMap = flow.flatMapMerge {
                requestFlow(it)
            }.flowOn(Dispatchers.IO)
            flowMap.collect {
                "it : $it".log()
            }
        }
        "Cost $time.".log()
    }
    val result2 = listOf<Int>(1, 2, 3, 4, 5).map {
        it.toString()
    }
    println("End")
    // flatMapConcat 和 flatMapMerge 的区别
    // flatMapConcat 将一个流中的每个元素都转换为一个流，然后将这些流合并成一个流
    // flatMapMerge 将一个流中的每个元素都转换为一个流，然后将这些流合并成一个流，并且按照顺序合并
}