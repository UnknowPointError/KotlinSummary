package MineBBS.NetWork

import MineBBS.BaseUtil.MINEBBS_RETROFIT
import MineBBS.Model.RequestURL
import Util.RetrofitExt.await
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/*
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/12 20:48 周二
@Description: test
*/

/* @formatter:off */
fun main() = runBlocking<Unit> {
        launch {
            try {
                println("sadasda")
                val request = MINEBBS_RETROFIT.create(RequestURL::class.java).getBaseEntity().await()
                println(request.data)
                println(request.ApiCodeName)
                println(request.isSuccess)
                println(request.message)
                println(request.ApiVersion)
                println(request.ApiCodeName)
                println(request.currentTime)
                println(request.codeStatus)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    launch {
        println("asdadasdasd")
    }

    //Flow接口的collect函数是什么？  将数据收集到一个集合中 并且返回一个Flow  可以被观察
}



