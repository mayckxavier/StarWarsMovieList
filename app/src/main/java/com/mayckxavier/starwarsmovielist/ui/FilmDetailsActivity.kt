package com.mayckxavier.starwarsmovielist.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.mayckxavier.starwarsmovielist.R
import com.mayckxavier.starwarsmovielist.data.Film
import kotlinx.android.synthetic.main.film_detail_activity.*

/**
 * Created by mayck on 19/11/17.
 */
class FilmDetailsActivity : AppCompatActivity() {
    lateinit var filmDetailsPresenter: FilmDetailsPresenter

    lateinit var filmTitle: TextView
    lateinit var filmOpeningCrawl: TextView
    lateinit var filmReleaseDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.film_detail_activity)

        filmTitle = film_details_title
        filmOpeningCrawl = film_detail_opening_crawl
        filmReleaseDate = film_detail_release_date

        filmDetailsPresenter = FilmDetailsPresenter(this)
        filmDetailsPresenter.loadData()
    }

    fun fillDescription(film: Film) {
        filmTitle.text = film.title
        filmOpeningCrawl.text = film.opening_crawl
        filmReleaseDate.text = "Released in " + film.release_date
    }
}