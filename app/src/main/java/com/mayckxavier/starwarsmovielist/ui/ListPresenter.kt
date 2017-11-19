package com.mayckxavier.starwarsmovielist.ui

import android.app.Activity
import android.content.Intent
import android.util.Log
import com.mayckxavier.starwarsmovielist.R
import com.mayckxavier.starwarsmovielist.RetrofitInitializer
import com.mayckxavier.starwarsmovielist.data.Film
import com.mayckxavier.starwarsmovielist.data.Films
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by mayck on 17/11/17.
 */
class ListPresenter(val listActivity: ListActivity) {
    lateinit var filmArrayAdapter: FilmListAdapter

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

                    filmArrayAdapter = FilmListAdapter(listActivity, films.results, R.layout.film_item)
                    listActivity.updateFilmList(filmArrayAdapter)
                    listActivity.dismissProgressBar()
                }
            }
        })
    }

    fun goToSelectedFilm(position: Int) {
        val film: Film = filmArrayAdapter.getItem(position)
        Log.e("onItemClick", film.title)
        listActivity.startActivity(Intent(listActivity,FilmDetailsActivity::class.java))
    }



}
