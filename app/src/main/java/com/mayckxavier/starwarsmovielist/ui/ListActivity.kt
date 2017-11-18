package com.mayckxavier.starwarsmovielist.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.mayckxavier.starwarsmovielist.R
import kotlinx.android.synthetic.main.list_activity.*

class ListActivity : AppCompatActivity() {

    private lateinit var movieList: ListView
    private lateinit var listPresenter: ListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        movieList = movie_list

        listPresenter = ListPresenter(this)
        listPresenter.loadMovies()
    }

    fun updateList(arrayAdapter: ArrayAdapter<String>) {
        movieList.adapter = arrayAdapter
    }
}
