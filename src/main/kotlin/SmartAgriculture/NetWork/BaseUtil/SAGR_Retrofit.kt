package SmartAgriculture.NetWork.BaseUtil

import SmartAgriculture.SAGR_CONFIG
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SAGR_Retrofit {

    private val retrofit = Retrofit.Builder()
        .baseUrl(SAGR_CONFIG.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(servicesClass: Class<T>): T = retrofit.create(servicesClass)

}