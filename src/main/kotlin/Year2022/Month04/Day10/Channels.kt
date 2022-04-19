package Year2022.Month04.Day10

import Util.log
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/10 18:40 周日
@Description: 
*/

class Channels {
    fun createChannel() {
        val channel = Channel<Int>(1) // 创建带有缓冲区的channel
        runBlocking {
            val sender = launch {
                repeat(8) {
                    "Sending $it.".log()
                    channel.send(it)
                }
            }
            launch {
                repeat(8) {
                    "Got ${channel.receive()}.".log()
                }
                sender.cancel()
                sender.isActive.log()
            }
        }
    }
}

fun main() {
    with(Channels()) {
        createChannel()
    }
}