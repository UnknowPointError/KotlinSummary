package SmartAgriculture.NetWork

import MineBBS.Model.SAGR_ModelEntity
import SAGR_RequestURL
import SmartAgriculture.NetWork.BaseUtil.SAGR_Retrofit
import SmartAgriculture.NetWork.BaseUtil.generateTokenInfo
import Util.RetrofitExt.await
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.RequestBody

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/21 12:30 周四
@Description: test
*/

class Demo {

}

suspend fun main() {
    val gson = Gson()
    val tokenInfo = generateTokenInfo()
    val root = gson.toJson(SAGR_ModelEntity.JsonEntity.User(tokenInfo[0],tokenInfo[1]))
    println(tokenInfo)
    val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), root)
    println(body)
    val response = SAGR_Retrofit.create(SAGR_RequestURL::class.java).getToken(body).await()
    println(response)
}

/*{
  "tags": {},
  "reported": {},
  "desired": {}
}*/