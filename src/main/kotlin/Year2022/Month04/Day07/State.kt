package Year2022.Month04.Day07

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/7 1:01 周四
@Description: 状态模式
*/

interface State {
    fun next(): State
}

sealed class SemaphoreStatesImpl : State {
    object Red : SemaphoreStatesImpl() {
        override fun next(): State = Green
    }

    object Green : SemaphoreStatesImpl() {
        override fun next(): State = Yellow
    }

    object Yellow : SemaphoreStatesImpl() {
        override fun next(): State = Red
    }
}

class Semaphore(startingState: State = SemaphoreStatesImpl.Red) {
    var state = startingState
        private set

    fun nextLight() {
        state = state.next()
    }

    fun getCurrentStateName(): String = state.javaClass.simpleName

}

fun Semaphore.canCross() = this.state is SemaphoreStatesImpl.Green

fun main() {
    val semaphore = Semaphore()
    repeat(5) {
        println("${semaphore.getCurrentStateName()}, can cross: ${semaphore.canCross()}")
        semaphore.nextLight()
    }
}