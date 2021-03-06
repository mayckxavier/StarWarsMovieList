package com.mayckxavier.starwarsmovielist.ui

import android.content.Intent
import android.util.Log
import com.mayckxavier.starwarsmovielist.R
import com.mayckxavier.starwarsmovielist.RetrofitInitializer
import com.mayckxavier.starwarsmovielist.data.Film
import com.mayckxavier.starwarsmovielist.data.Films
import com.mayckxavier.starwarsmovielist.ui.adapter.FilmListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable

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
                listActivity.dismissProgressBar("Web couldn't get the film list. Is your internet connection working?")
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
        listActivity.showProgressDialog("Loading film")

        val film: Film = filmArrayAdapter.getItem(position)

        val call = RetrofitInitializer().filmService().search(film.filmId())

        call.enqueue(object : Callback<Film> {
            override fun onFailure(call: Call<Film>?, t: Throwable?) {
                Log.e("erro onFailure", t?.message)
                listActivity.dismissProgressDialog("Web couldn't get the film list. Is your internet connection working?")
            }

            override fun onResponse(call: Call<Film>?, response: Response<Film>?) {
                response?.body()?.let {
                    val film = it

                    val intent = Intent(listActivity, FilmDetailsActivity::class.java)
                    intent.putExtra("film", film as Serializable)

                    listActivity.dismissProgressDialog()
                    listActivity.startActivity(intent)
                    Log.e("onResponse", it.director)
                }

            }
        })
    }
}
