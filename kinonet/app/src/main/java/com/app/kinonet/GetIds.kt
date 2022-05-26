package com.app.kinonet

import android.util.Log

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.IOException
import java.util.ArrayList

// Fuck Arystan
class GetIds {
    suspend fun doInBackground(vararg params: String): List<String> {
        val ids: MutableList<String> = ArrayList()
        var title = ""
        val doc: Document // Fuck Arystan
        try {
            doc = Jsoup.connect("https://www.kinopoisk.ru/index.php?kp_query=" + params[0]).get()
            title = doc.title()
            Log.v("Success", title)
            val results = doc.select(".element")
            for (i in 0..4) {
                if (i+1>results.size) {
                    break
                }
                val `as` = results[i].select("a")
                val id = `as`.first()!!.attr("data-id")
                Log.v("Found", id)
                ids.add(id)
            }
        } catch (e: IOException) {
            Log.v("Fuck Arystan", "Ebnulos vse")
            e.printStackTrace()
        }
        return ids
    }
}