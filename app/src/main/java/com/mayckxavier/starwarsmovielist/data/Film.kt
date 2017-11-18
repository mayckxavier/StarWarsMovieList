package com.mayckxavier.starwarsmovielist.data

/**
 * Created by mayck on 18/11/17.
 */
class Film(val title: String,
           val episodeId: Int,
           val openingCrawl: String,
           val director: String,
           val producer: String) {

    override fun toString(): String {
        return title
    }
}