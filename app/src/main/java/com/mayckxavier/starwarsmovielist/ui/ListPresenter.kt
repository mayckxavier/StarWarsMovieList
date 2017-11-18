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
        val call = RetrofitInitializer().filmService().list()
        call.enqueue(object : Callback<Films> {
            override fun onFailure(call: Call<Films>?, t: Throwable?) {
                Log.e("erro onFailure", t?.message)
            }


            override fun onResponse(call: Call<Films>?, response: Response<Films>?) {
                response?.body()?.let {
                    val films: Films = it
//                    listActivity.updateList()

                    val arrayAdapter = FilmListAdapter(films.results, listActivity)
//                    val arrayAdapter = ArrayAdapter(listActivity, R.layout.simple_list_item_1, films)

//                    val recyclerView = note_list_recyclerview
//                    recyclerView.adapter = NoteListAdapter(notes, this)
//                    val layoutManager = StaggeredGridLayoutManager(
//                            2, StaggeredGridLayoutManager.VERTICAL)
//                    recyclerView.layoutManager = layoutManager


                    listActivity.updateList(arrayAdapter)

                }
            }
        })


        val movies = listOf("Star Wars III - Uma Nova Esperança",
                "Star Wars IV - O Império Contra-ataca",
                "Star Wars V - O Retorno de Jedi")


    }

//    fun films(): List<Film> {
//
//    }
}
