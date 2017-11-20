package com.mayckxavier.starwarsmovielist.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.mayckxavier.starwarsmovielist.R
import kotlinx.android.synthetic.main.list_activity.*


class ListActivity : AppCompatActivity() {

    private lateinit var movieList: ListView
    private lateinit var listPresenter: ListPresenter
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        movieList = film_list
        progressDialog = ProgressDialog(this)
        listPresenter = ListPresenter(this)

    }

    override fun onResume() {
        super.onResume()
        listPresenter.loadMovies()

        swiperefresh.setOnRefreshListener {
            listPresenter.loadMovies()
        }

        movieList.setOnItemClickListener { adapterView: AdapterView<*>, view1: View, position: Int, l: Long ->
            listPresenter.goToSelectedFilm(position)
        }
    }

    fun cleanFilmList() {
        movieList.adapter = null
    }

    fun updateFilmList(arrayAdapter: FilmListAdapter) {
        movieList.adapter = arrayAdapter
    }

    fun showProgressDialog(msg: String = "") {
        progressDialog.setMessage(msg)
        progressDialog.show()
    }

    fun dismissProgressDialog(msg: String = "") {
        if (progressDialog.isShowing) {
            progressDialog.dismiss()
        }
        if (msg.isNotBlank()) {
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
    }

    fun showProgressBar() {
        swiperefresh.isRefreshing = true
        progressbar.visibility = View.VISIBLE
    }

    fun dismissProgressBar(msg: String = "") {
        swiperefresh.isRefreshing = false
        progressbar.visibility = View.GONE

        if (msg.isNotBlank()) {
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
    }
}
