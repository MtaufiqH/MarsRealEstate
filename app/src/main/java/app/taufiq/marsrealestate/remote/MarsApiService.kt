package app.taufiq.marsrealestate.remote

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET

/**
 * Created By Taufiq on 8/15/2020.
 *
 */

private const val BASE_URL = " https://android-kotlin-fun-mars-server.appspot.com/"

/**
 * Create a Retrofit Builder
 * [ScalarsConverterFactory], that tells retrofit what do with the data
 * it gets back from web service. supports strings and other primitive types
 * */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    @GET("realestate")
    fun getProperties(): Call<String>
}

object MarsApi{
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}