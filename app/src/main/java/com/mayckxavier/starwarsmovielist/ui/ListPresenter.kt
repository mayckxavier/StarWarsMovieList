package com.mayckxavier.starwarsmovielist.ui

import android.R
import android.widget.ArrayAdapter

/**
 * Created by mayck on 17/11/17.
 */
class ListPresenter(val listActivity: ListActivity) {

    fun loadMovies(){
        val movies = listOf("Star Wars III - Uma Nova Esperança",
                "Star Wars IV - O Império Contra-ataca",
                "Star Wars V - O Retorno de Jedi")

        val arrayAdapter = ArrayAdapter(listActivity, R.layout.simple_list_item_1, movies)
        listActivity.updateList(arrayAdapter)
    }
}