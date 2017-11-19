package com.mayckxavier.starwarsmovielist.ui

import android.app.ProgressDialog
import android.opengl.Visibility
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import com.mayckxavier.starwarsmovielist.R
import kotlinx.android.synthetic.main.list_activity.*
import android.widget.RelativeLayout


class ListActivity : AppCompatActivity() {

    private lateinit var movieList: ListView
    private lateinit var listPresenter: ListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        movieList = movie_list
        listPresenter = ListPresenter(this)
        listPresenter.loadMovies()

        swiperefresh.setOnRefreshListener {
            movieList.adapter = null
            listPresenter.loadMovies()
        }
    }

    fun updateList(arrayAdapter: FilmListAdapter) {
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
