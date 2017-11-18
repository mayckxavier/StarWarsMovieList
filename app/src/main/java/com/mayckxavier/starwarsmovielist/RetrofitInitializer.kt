package com.mayckxavier.starwarsmovielist

import com.mayckxavier.starwarsmovielist.data.FilmService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


/**
 * Created by mayck on 18/11/17.
 */
class RetrofitInitializer {
    private var retrofit: Retrofit

    init {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val originalHttpUrl = original.url()

                val url = originalHttpUrl.newBuilder()
                        .addQueryParameter("format", "json")
                        .build()

                // Request customization: add request headers
                val requestBuilder = original.newBuilder()
                        .url(url)

                val request = requestBuilder.build()
                return chain.proceed(request)
            }
        }).addInterceptor(logging)

        retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
    }

    fun filmService(): FilmService {
        return retrofit.create(FilmService::class.java)
    }
}
