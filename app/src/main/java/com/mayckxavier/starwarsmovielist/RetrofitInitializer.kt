package com.mayckxavier.starwarsmovielist

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by mayck on 18/11/17.
 */
class RetrofitInitializer {
    fun init() {
        Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}