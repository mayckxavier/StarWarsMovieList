package com.mayckxavier.starwarsmovielist.ui

import com.mayckxavier.starwarsmovielist.data.Film

/**
 * Created by mayck on 19/11/17.
 */
class FilmDetailsPresenter(val filmDetailsActivity: FilmDetailsActivity) {
    fun loadData() {
        val film = filmDetailsActivity.intent.extras.get("film") as Film
        filmDetailsActivity.fillDescription(film)
    }
}