package com.app.kinonet

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import com.app.kinonet.home.activities.FoodDetails
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream

import java.net.URISyntaxException
import java.sql.Array

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class SearchActivity : AppCompatActivity() {
    val act = this
    var edtext: EditText? = null
    var task = GetIds()
    var taskparse = GetParse()
    var taskrate = GetRate()
    private lateinit var but: ImageView
    var ids: List<String>? = null
    var rates: List<List<String>>? = null
    var movies: List<Movie>? = null
    val db = Firebase.firestore
    var anim:AnimationDrawable?=null
    var iim:ImageView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_search)
        iim = findViewById<ImageView>(R.id.loadserch)
        but = findViewById(R.id.abosh)
        anim = iim?.drawable as AnimationDrawable
        edtext = findViewById<View>(R.id.search_view_field) as EditText
        edtext!!.setOnEditorActionListener { v, actionID, event ->
            if (actionID == EditorInfo.IME_ACTION_SEARCH) {
                iim?.visibility = View.VISIBLE
                anim?.start()
                val query = edtext!!.text.toString()
                find(query)
                true
            }
            else
            {
                false
            }

        }
        but.setOnClickListener(View.OnClickListener {
            iim?.visibility = View.VISIBLE
            anim?.start()
            val query = edtext!!.text.toString()
            query.replace(" ", "+")
            find(query)

        }
        )


    }
    fun find(query:String) {
        GlobalScope.launch {
            ids = task.doInBackground(query)
            var out = taskparse.doInBackground(ids!!)
            withContext(Dispatchers.Main) {
                build(out)
            }
        }
    }
    fun build(out:List<Movie>) {
        iim?.visibility = View.GONE
        val adapter = MovieAdapter(act, out)
        val listView = findViewById<View>(R.id.list) as ListView
        listView.adapter = adapter
        listView.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            val intent = Intent(baseContext, FoodDetails::class.java)
            val movie = hashMapOf(
                "id" to out[position].id,
                "name" to out[position].name,
                "desc" to out[position].desc,
                "director" to out[position].director,
                "imgurl" to out[position].imgurl,
                "runt" to out[position].runt,
                "genre" to out[position].genre,
                "kp_rate" to out[position].kp_rate,
                "im_rate" to out[position].im_rate,
                "actor1" to out[position].actores[0],
                "actor2" to out[position].actores[1],
                "actor3" to out[position].actores[2],
                "slogan" to out[position].slogan
            )
            db.collection("movies").document("" +out[position].id).set(movie)
            val name = out[position].name

            val desc = out[position].desc

            val dir = out[position].director
            val bm = out[position].image
            val bos = ByteArrayOutputStream()

            val img = bos.toByteArray()
            val scaledbmp =
                Bitmap.createScaledBitmap(bm, 300, 300, true) // bmp is your Bitmap instance
            // PNG is a lossless format, the compression factor (100) is ignored
            val kp_rate = out!![position].kp_rate
            val im_rate = out!![position].im_rate

            intent.putExtra("KP", kp_rate)
            intent.putExtra("IM", im_rate)
            val actores = out[position].actores

            intent.putExtra("MoviePoster", scaledbmp)
            intent.putExtra("MovieName", name)
            intent.putExtra("MovieDir", dir)
            intent.putExtra("MovieDesc", desc)
            intent.putExtra("MovieId", ids!![position])
            for (i in 0..2) {
                intent.putExtra("Actor$i", actores[i])
            }
            startActivity(intent)
        }
    }

    }
