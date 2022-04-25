import MineBBS.Model.SAGR_ModelEntity
import com.google.gson.annotations.SerializedName
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/12 21:19 周二
@Description: 指向数据模型
*/

interface SAGR_RequestURL {

    @POST("auth")
    fun getToken(
        @Body request: RequestBody
    ): Call<SAGR_ModelEntity.POST.TokenEntity>
}