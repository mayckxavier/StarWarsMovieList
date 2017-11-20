package com.mayckxavier.starwarsmovielist.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by mayck on 18/11/17.
 */
interface FilmService {
    @GET("films")
    fun list(): Call<Films>


    @GET("films/{id}")
    fun search(@Path("id") id: String): Call<Film>

}