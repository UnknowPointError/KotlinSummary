package Year2022.Month04.Day11

import Util.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/11 9:22 周一
@Description: BackPressure 背压
*/

class FlowSummary02 {
}
//什么是冷流？    冷流是一个可以被暂停的流，它可以被暂停，也可以被恢复。
//什么是热流？    热流是一个可以被暂停的流，它可以被暂停，也可以被恢复。
fun currTime() = System.currentTimeMillis()
fun main() = runBlocking<Unit> {
    var start: Long = 0
    val time = measureTimeMillis {
        (1..5)
            .asFlow()
            .onStart { start = currTime() }
            .onEach {
                delay(100)
                "Emit $it (${currTime() - start}ms).".log()
            }
            .conflate()
            .collect {
                "Collect $it starts (${currTime() - start}ms).".log()
                delay(500)
                "Collect $it ends (${currTime() - start}ms).".log()
            }
    }
    "Cost $time ms.".log()
    "----------------------------------------".log()
    flow {
        List(100) {
            "Emit $it.".log(false)
            emit(it)
        }
    }.conflate()
        .collect {
            "".log()
            "Collect $it".log()
            delay(100)
            "Collected $it".log()
        }
}