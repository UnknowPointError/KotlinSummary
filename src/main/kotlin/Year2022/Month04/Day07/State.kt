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
    //SemaphoreStatesImpl实现了哪些接口
    println(SemaphoreStatesImpl::class.java.interfaces.joinToString())
    // 使用when来判断是红绿灯，不可以使用getCurrentStateName函数
    when (semaphore.state) {
        is SemaphoreStatesImpl.Red -> println("Red")
        is SemaphoreStatesImpl.Green -> println("Green")
        is SemaphoreStatesImpl.Yellow -> println("Yellow")
    }
    println("==============================")
    repeat(5) {
        println("${semaphore.getCurrentStateName()}, can cross: ${semaphore.canCross()}")
        semaphore.nextLight()
    }
}
// 根据上下文分析一下我写的是什么模式?   状态模式