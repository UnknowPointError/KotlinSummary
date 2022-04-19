package MineBBS.BaseUtil

import MineBBS.MineBBS_Config
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object RetrofitExt {

    private val retrofit = Retrofit.Builder()
        .baseUrl(MineBBS_Config.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(servicesClass: Class<T>): T = retrofit.create(servicesClass)

    suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    with(response.body()) {
                        if (this != null) continuation.resume(this)
                        else continuation.resumeWithException(RuntimeException("response body is null."))
                    }
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }

    }
}