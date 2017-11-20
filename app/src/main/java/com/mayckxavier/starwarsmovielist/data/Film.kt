package com.mayckxavier.starwarsmovielist.data

import java.io.Serializable

/**
 * Created by Mayck Xavier <contato@mayckxavier.com> on 18/11/17.
 */
class Film(val title: String,
           val episode_id: Int,
           val opening_crawl: String,
           val director: String,
           val producer: String,
           val release_date: String,
           val url: String): Serializable {

    override fun toString(): String {
        return title
    }

    fun filmId(): String {
        val splited = url.split("/")


        // for(part in splited){
        //     if(!part.isBlank()){
        //		stringParts.add(part)
        //   }
        //}
        //Deixado apenas como exemplo e aprendizado. O código abaixo é o equivalente ao acima
        val stringParts: MutableList<String> = splited
                .filterNot { it.isBlank() }
                .toMutableList()

        return (stringParts[stringParts.lastIndex])
    }
}