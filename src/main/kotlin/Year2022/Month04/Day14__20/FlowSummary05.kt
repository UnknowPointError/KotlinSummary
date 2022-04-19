package Year2022.Month04.Day14__20

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/13 23:08 周三
@Description: 并行操作
*/

@OptIn(FlowPreview::class)
fun main() = runBlocking {
    val flowA = mutableListOf("A", "B", "C", "D", "E")
    val result = (1..50).toMutableList()
    result.asFlow().flatMapMerge() {
        flow {
            emit(it)
            delay(1000)
        }
    }.flowOn(Dispatchers.IO).collect {
        println("$it")
    }
    println("-------------")
    val i = flowA.zip(result).forEach {it ->
        println("${it.first} ${it.second}")
    }
    println("------flatMapLatest-------")
    (0..10).asFlow().flatMapLatest {
        flow {
            emit(it)
            println("emit $it.")
            delay(1000)

        }
    }.collect{
        println(it)
    }
    println("-------------")
    (0..10).asFlow().flatMapConcat {
        flow {
            emit(it)
            println("emit $it.")
            delay(10)

        }
    }.collect{
        println(it)
    }
}
