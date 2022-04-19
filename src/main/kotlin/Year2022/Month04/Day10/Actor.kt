package Year2022.Month04.Day10

import Util.log
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.ContinuationInterceptor

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/10 20:11 周日
@Description: Actor
*/

class Actor

fun main() = runBlocking<Unit> {
    coroutineContext[ContinuationInterceptor]
    launch {
        val summer = actor<Int>(coroutineContext) {
            var sum = 0
            for (i in channel) {
                sum += i
                "i = $i  Sum = $sum".log()
            }
        }
        repeat(10) { i ->
            summer.send(i)
            if (i == 5) this.coroutineContext.cancel()
        }
        summer.close()
    }
}
