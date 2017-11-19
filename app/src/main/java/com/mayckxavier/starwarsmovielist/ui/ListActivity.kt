package com.mayckxavier.starwarsmovielist.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ListView
import com.mayckxavier.starwarsmovielist.R
import kotlinx.android.synthetic.main.list_activity.*


class ListActivity : AppCompatActivity() {

    private lateinit var movieList: ListView
    private lateinit var listPresenter: ListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        movieList = film_list
        listPresenter = ListPresenter(this)

    }

    override fun onResume() {
        super.onResume()
        listPresenter.loadMovies()

        swiperefresh.setOnRefreshListener {
            listPresenter.loadMovies()
        }
    }

    fun cleanFilmList() {
        movieList.adapter = null
    }

    fun updateFilmList(arrayAdapter: FilmListAdapter) {
        movieList.adapter = arrayAdapter
    }

    fun showProgressBar() {
        progressbar.visibility = View.VISIBLE
    }

    fun dismissProgressBar() {
        swiperefresh.isRefreshing = false
        progressbar.visibility = View.GONE
    }
}
