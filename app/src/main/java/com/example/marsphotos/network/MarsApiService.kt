package com.example.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

//builder --flat--3M, carpark-5lac, marble-2lac,interior-3lac
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create()) //optionals/toppings
    .baseUrl(BASE_URL)
    .build()


interface MarsApiService {

    @GET("photos")
   suspend fun getPhotos():String

}

//object = singleton design pattern
//by = delegation pattern
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

}

