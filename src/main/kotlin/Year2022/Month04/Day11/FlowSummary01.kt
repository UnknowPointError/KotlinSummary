package Year2022.Month04.Day11

import Util.log
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/11 1:15 周一
@Description: Flow的深入学习
*/

class FlowSummary01 {

}
//所谓冷流，即下游无消费行为时，上游不会产生数据，只有下游开始消费，上游才从开始产生数据。

//而所谓热流，即无论下游是否有消费行为，上游都会自己产生数据。
fun main() = runBlocking<Unit> {
    (1..5).asFlow().onEach {
        if (it == 3) throw RuntimeException("Error on $it")
    }
        .onStart { "(1)Starting flow.".log() }
        .onEach { "(2)On each $it.".log() }
        .catch { "(4)Exception : ${it.message}.".log() }
        .onCompletion { "(5)Flow completed.".log() }
        .collect {
            "(3)Start collect $it.".log()
        }
    (1..5).asFlow().onEach {
        if (it == 3) throw RuntimeException("Error on $it")
    }
        .onStart { "(1)Starting flow.".log() }
        .onEach { "(2)On each $it.".log() }
        .catch { "(4)Exception : ${it.message}.".log() }
        .onCompletion { "(5)Flow completed.".log() }
        .collect {
            "(3)Start collect $it.".log()
        }
    "------------------------".log()
    flow {
        for (i in 1..5) {
            "send $i".log()
            emit(i)
        }
    }.onEach {
        delay(1000)
        "(6)On each $it.".log()
    }.collect {
        "(7)Collect $it.".log()
        "(7)Collected $it.".log()
    }
}