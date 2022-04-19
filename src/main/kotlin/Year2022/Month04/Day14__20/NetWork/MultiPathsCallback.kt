package Year2022.Month04.Day14__20.NetWork

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/17 8:27 周日
@Description: 多路径下载接口
*/

interface MultiPathsCallback<T> {

    fun onProgress(value: Int)

    fun onResult(value: T)

    fun onError(throwable: Throwable)

    fun onComplete()
}
