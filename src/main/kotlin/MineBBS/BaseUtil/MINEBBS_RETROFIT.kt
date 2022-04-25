package MineBBS.BaseUtil

import MineBBS.MINEBBS_CONFIG
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MINEBBS_RETROFIT {
    private val retrofit = Retrofit.Builder()
        .baseUrl(MINEBBS_CONFIG.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(servicesClass: Class<T>): T = retrofit.create(servicesClass)
}