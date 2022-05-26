package com.app.kinonet

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.URL

class GetParse {

    var lis: MutableList<Movie> = ArrayList()
    val storage = Firebase.storage
    val storageRef = storage.reference
    val db = Firebase.firestore
    val ONE_MEGABYTE: Long = 1024 * 1024
    suspend fun doInBackground(vararg lists: List<String>): List<Movie> {
        for (i in lists[0].indices) {
            /*val doc = db.collection("movies").document("" + lists[0][i])
            if (doc!=null) {
                val source = Source.DEFAULT
                val mov = Movie()
                doc.get(source).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val document = task.result
                        if (document.exists()) {
                        mov.id = document.getLong("id")!!.toInt()
                        mov.name = document.getString("name")
                        mov.desc = document.getString("desc")
                        mov.desc = document.getString("director")
                        mov.imgurl = document.getString("imgurl")
                        mov.kp_rate = document.getString("kp_rate")
                        mov.im_rate = document.getString("im_rate")
                        mov.actores.add("actor1")
                        mov.actores.add("actor2")
                        mov.actores.add("actor3")
                        }
                    } else {
                        try {
                            val movieRef = storageRef.child(lists[0][i] + ".png")
                            val mov = Movie()
                            mov.id = Integer.valueOf(lists[0][i])
                            val doc =
                                Jsoup.connect("https://webcache.googleusercontent.com/search?q=cache:https://www.kinopoisk.ru/film/" + lists[0][i])
                                    .get()
                            val doc2 = Jsoup.connect("https://rating.kinopoisk.ru/" + lists[0][i] + ".xml").get()
                            val kp = doc2.select("kp_rating")
                            val im = doc2.select("imdb_rating")
                            val titlename = doc.select("span[data-tid=75209b22]")
                            val desc = doc.select("p.styles_paragraph__wEGPz")
                            val desc2 = doc.select("p.styles_paragraph__1NPrt")
                            val actors = doc.select("a[itemprop=actor]")
                            val div = doc.select("div:contains(Режиссер)")[13]
                            val director = div.select("a[data-tid=603f73a4]")
                            if (titlename.size == 0) // Man Fuck Arystan
                            {
                                Log.v("Nullpointer", doc.select("span").first()!!.text())
                            }
                            mov.name = titlename.first()!!.text()
                            mov.kp_rate = kp.first()!!.text()
                            mov.im_rate = im.first()!!.text()
                            Log.v("MovieTitle", mov.name)
                            if (desc.first() == null) {
                                mov.desc = desc2.first()!!.text()
                            } else {
                                mov.desc = desc.first()!!.text()
                            }

                            Log.v("MovieDesc", mov.desc)
                            mov.director = director.first()!!.text()
                            Log.v("MovieDirector", mov.director)
                            val img = doc.select("img.film-poster")
                            val pUrl = "https:" + img.first()!!.attr("src")
                            Log.v("MovieImage", img.first()!!.attr("src"))
                            val tUrl = URL(pUrl)
                            val imgbitmap =
                                BitmapFactory.decodeStream(tUrl.openConnection().getInputStream())
                            mov.image = imgbitmap
                            val baos = ByteArrayOutputStream()
                            mov.image.compress(Bitmap.CompressFormat.PNG, 100, baos)
                            val data = baos.toByteArray()
                            var uploadTask = movieRef.putBytes(data)

                            val urlTask = uploadTask.continueWithTask { task ->
                                if (!task.isSuccessful) {
                                    task.exception?.let {
                                        throw it
                                    }
                                }
                                movieRef.downloadUrl
                            }.addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val downloadUri = task.result
                                    mov.imgurl = downloadUri.toString()
                                }
                            }
                            Log.v("MovieImage", mov.image.toString())
                            for (j in 0..2) {
                                mov.actores.add(actors[j].text())
                                Log.v("Movieactors", mov.actores[j])
                            }
                            lis.add(mov)
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }


                }

            } else {*/
                try {
                    val movieRef = storageRef.child(lists[0][i] + ".png")
                    val mov = Movie()
                    mov.id = Integer.valueOf(lists[0][i])
                    var doc =
                        Jsoup.connect("https://webcache.googleusercontent.com/search?q=cache:https://www.kinopoisk.ru/film/" + lists[0][i])
                            .get()
                    val doc2 = Jsoup.connect("https://rating.kinopoisk.ru/" + lists[0][i] + ".xml").get()
                    var titlename = doc.select("span[data-tid=75209b22]")
                    if (titlename.size == 0) // Man Fuck Arystan
                    {
                        doc = Jsoup.connect("https://webcache.googleusercontent.com/search?q=cache:https://www.kinopoisk.ru/series/" + lists[0][i])
                            .get()
                        titlename = doc.select("span[data-tid=75209b22]")
                        if (titlename.size==0) {

                            break
                        }
                    }
                    val kp = doc2.select("kp_rating")
                    val im = doc2.select("imdb_rating")
                    val genre = doc.select("div[data-tid=28726596]").first()?.select("a[data-tid=603f73a4]")?.first()

                    val desc = doc.select("p.styles_paragraph__wEGPz")
                    val desc2 = doc.select("p.styles_paragraph__1NPrt")
                    val actors = doc.select("a[itemprop=actor]")
                    var slog: Element? = null
                    if (doc.select("div[data-tid=e1e37c21]").size>2) {
                        slog = doc.select("div[data-tid=e1e37c21]")[2]
                    }
                    else if(doc.select("div[data-tid=e1e37c21]").size>1) {
                        slog = doc.select("div[data-tid=e1e37c21]")[0]
                    }
                    else {
                        slog = doc.select("div[data-tid=e1e37c21]").first()
                    }
                    val div = doc.select("div:contains(Режиссер)")[13]
                    val director = div.select("a[data-tid=603f73a4]")
                    val runt = doc.select("div[data-tid=e1e37c21]").last()

                    mov.name = titlename.first()!!.text()
                    mov.kp_rate = kp.first()!!.text()
                    mov.im_rate = im.first()!!.text()
                    mov.slogan = slog?.text()
                    mov.genre = genre?.text()
                    Log.v("Moviegen", mov.genre)
                    mov.runt = runt?.text()
                    Log.v("RUnt", mov.runt)
                    Log.v("MovieTitle", mov.name)
                    if (desc.first() == null) {
                        mov.desc = desc2.first()!!.text()
                    } else {
                        mov.desc = desc.first()!!.text()
                    }

                    Log.v("MovieDesc", mov.desc)
                    mov.director = director.first()!!.text()
                    Log.v("MovieDirector", mov.director)
                    val img = doc.select("img.film-poster")
                    val pUrl = "https:" + img.first()!!.attr("src")
                    Log.v("MovieImage", img.first()!!.attr("src"))
                    val tUrl = URL(pUrl)
                    val imgbitmap =
                        BitmapFactory.decodeStream(tUrl.openConnection().getInputStream())
                    mov.image = imgbitmap
                    val baos = ByteArrayOutputStream()
                    mov.image.compress(Bitmap.CompressFormat.PNG, 100, baos)
                    val data = baos.toByteArray()
                    baos.close()
                    var uploadTask = movieRef.putBytes(data)

                    val urlTask = uploadTask.continueWithTask { task ->
                        if (!task.isSuccessful) {
                            task.exception?.let {
                                throw it
                            }
                        }
                        movieRef.downloadUrl
                    }.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val downloadUri = task.result
                            mov.imgurl = downloadUri.toString()
                        }
                    }
                    Log.v("MovieImage", mov.image.toString())
                    for (j in 0..2) {
                        mov.actores.add(actors[j].text())
                        Log.v("Movieactors", mov.actores[j])
                    }
                    lis.add(mov)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

        Log.v("SeriousLast", lis.toString())
        return lis
    }



}