package com.mayckxavier.starwarsmovielist.ui

import android.util.Log
import com.mayckxavier.starwarsmovielist.RetrofitInitializer
import com.mayckxavier.starwarsmovielist.data.Films
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by mayck on 17/11/17.
 */
class ListPresenter(val listActivity: ListActivity) {
    init {

    }

    fun loadMovies() {
        listActivity.showProgressBar()
        listActivity.cleanFilmList()

        val call = RetrofitInitializer().filmService().list()
        call.enqueue(object : Callback<Films> {
            override fun onFailure(call: Call<Films>?, t: Throwable?) {
                Log.e("erro onFailure", t?.message)
                listActivity.dismissProgressBar()
            }

            override fun onResponse(call: Call<Films>?, response: Response<Films>?) {
                response?.body()?.let {
                    val films: Films = it

                    val arrayAdapter = FilmListAdapter(films.results, listActivity)
                    listActivity.updateFilmList(arrayAdapter)
                    listActivity.dismissProgressBar()
                }
            }
        })
    }
}
