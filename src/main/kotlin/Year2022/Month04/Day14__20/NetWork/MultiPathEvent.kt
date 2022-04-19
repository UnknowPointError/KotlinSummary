package Year2022.Month04.Day14__20.NetWork

/*
@Machine: RedmiBook Pro 15
@Author: Barry
@Time: 2022/4/17 8:41 周日 上午
@Description: 多路径下载事件模板
*/

sealed interface MultiPathEvent
class OnProgress(val value: Int) : MultiPathEvent
class OnResult<T>(val value: T) : MultiPathEvent
class OnError(val throwable: Throwable) : MultiPathEvent
object OnComplete : MultiPathEvent

