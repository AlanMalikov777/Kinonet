package com.app.kinonet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.kinonet.R
import android.graphics.Bitmap
import android.widget.TextView
import android.widget.RatingBar
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MovieInfo : AppCompatActivity() {
    var but: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_info)
        val name = intent.extras!!.getString("MovieName")
        but = findViewById<View>(R.id.site) as Button
        val image = intent.extras!!.getParcelable<Bitmap>("MoviePoster")
        val poster = findViewById<ImageView>(R.id.imageView)
        poster.setImageBitmap(image)
        val mname = findViewById<View>(R.id.movie_title) as TextView
        mname.text = name
        val desc = intent.extras!!.getString("MovieDesc")
        val mdesc = findViewById<View>(R.id.movie_desc) as TextView
        mdesc.text = desc
        val dir = intent.extras!!.getString("MovieDir")
        val mdir = findViewById<View>(R.id.dir) as TextView
        mdir.text = dir
        val actor1 = intent.extras!!.getString("Actor0")
        val actor2 = intent.extras!!.getString("Actor1")
        val actor3 = intent.extras!!.getString("Actor2")
        val mid = intent.extras!!.getString("MovieId")
        val kp_rate = java.lang.Float.valueOf(intent.extras!!.getString("KP"))
        val im_rate = java.lang.Float.valueOf(intent.extras!!.getString("IM"))
        val mkp = findViewById<View>(R.id.rating1) as RatingBar
        val mim = findViewById<View>(R.id.rating2) as RatingBar
        mkp.rating = kp_rate
        mim.rating = im_rate
        val tkp = findViewById<View>(R.id.kpint) as TextView
        val tim = findViewById<View>(R.id.imint) as TextView
        tim.text = im_rate.toString()
        tkp.text = kp_rate.toString()
        val mactor1 = findViewById<View>(R.id.actor1) as TextView
        val mactor2 = findViewById<View>(R.id.actor2) as TextView
        val mactor3 = findViewById<View>(R.id.actor3) as TextView
        mactor1.text = actor1
        mactor2.text = actor2
        mactor3.text = actor3
        Log.v("Retrieved", "")
        but!!.setOnClickListener {
            val websiteIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kinopoisk.ru/film/$mid"))
            startActivity(websiteIntent)
        }
    }
}