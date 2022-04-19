package Year2022.Month04.Day14__20.Coroutines

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/16 22:03 周六
@Description: Produce
*/

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking {
    val i = produce {
        println("produce")
        send(2)
    }
    println("asdasd")
    println(i.receive())
    println("Main End.")
}