package com.mayckxavier.starwarsmovielist

import android.app.Application

/**
 * Created by mayck on 18/11/17.
 */
class StarWarsMovieList : Application() {
    override fun onCreate() {
        super.onCreate()
        RetrofitInitializer()
    }
}