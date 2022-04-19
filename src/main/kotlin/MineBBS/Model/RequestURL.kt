package MineBBS.Model

import MineBBS.MineBBS_Config
import retrofit2.Call
import retrofit2.http.GET

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/4/12 21:19 周二
@Description: 指向数据模型
*/

interface RequestURL {
    @GET(MineBBS_Config.BASE_URL_API_VERSION)
    fun getBaseEntity() : Call<ModelEntity.GET.BaseEntity>
}