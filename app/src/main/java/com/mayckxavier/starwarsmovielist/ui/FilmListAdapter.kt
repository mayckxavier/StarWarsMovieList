package com.mayckxavier.starwarsmovielist.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.mayckxavier.starwarsmovielist.R
import com.mayckxavier.starwarsmovielist.data.Film
import kotlinx.android.synthetic.main.film_item.view.*

/**
 * Created by mayck on 18/11/17.
 */

class FilmListAdapter(private val films: List<Film>, private val context: Context) : BaseAdapter() {

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {

        val film = films[position]

        val filmItem = LayoutInflater.from(context).inflate(R.layout.film_item, viewGroup, false)
        filmItem.film_item_title.setText(film.title)
        return filmItem
    }

    override fun getItem(position: Int): Film {
        return films[position]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return films.size
    }
}