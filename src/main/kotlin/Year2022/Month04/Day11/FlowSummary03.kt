package Year2022.Month04.Day11

import Util.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/11 11:11 周一
@Description: BackPressure
*/

class FlowSummary03 {
}


fun main() = runBlocking<Unit> {
    flowOf(4, 5, 6)
        .onStart { "Started.".log() }
        .onCompletion { "Completed.".log() }
        .onEach { value -> "Each value : $value.".log() }
        .collectIndexed { index, value ->
            "index : $index  value : $value".log()
            delay(100)
        }
    flow {
        for (i in 1..3) {
            "value : $i".log()
            emit(i)
        }
    }.map {
        /* map操作符是什么？ 将每个元素转换为另一个元素
        可以改变每个元素的类型
        可以改变每个元素的数量
        不可以改变每个元素的顺序
        可以改变每个元素的值 */
        it * it
    }.collect {
        it.log()
    }
    /* ------------retry------------ */
    "".log()
    (1..5).asFlow()
        .onEach { if (it == 3) throw RuntimeException("Error on $it") }
        .retry(2) {
            if (it is RuntimeException) return@retry true
            false
        }
        .onEach { "Emitting $it.".log() }
        .catch { /*it.printStackTrace()*/ }
        .collect()
    /* ------------retryWhen------------ */
    "".log()
    "-----------------------------------".log()
    (1..5).asFlow()
        .onEach { if (it == 3) throw RuntimeException("Error on $it") }
        .retryWhen { cause, attempt ->
            "$attempt and $cause".log()
            attempt < 2
        }
        .onEach { "Emitting $it.".log() }
        .catch { /*it.printStackTrace()*/ }
        .collect()
}