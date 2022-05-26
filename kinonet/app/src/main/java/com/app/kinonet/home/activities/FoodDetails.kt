package com.app.kinonet.home.activities

import android.graphics.Bitmap
import android.graphics.drawable.AnimationDrawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.app.kinonet.R
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.app.kinonet.GetRate
import com.app.kinonet.ImgCollectedListener
import com.app.kinonet.home.adapter.Main3TabsAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FoodDetails : AppCompatActivity() {
    val fr = Firebase.firestore
    var imgurl:String?=null
    var imgFullImage: ImageView? = null
    var imgBack: ImageView? = null
    var image:Bitmap?=null
    val act = this
    var name:String? = null
    var im:String? = null
    var kp:String? = null
    var runt:String? = null
    var gen:String? = null
    var desc:String? = null
    var actor1:String? = null
    var actor2:String? = null
    var actor3:String? = null
    var director:String? = null
    var mvname:TextView?=null
    var im_rate:TextView?=null
    var kp_rate:TextView?=null
    var runtime:TextView?=null
    var genview:TextView?=null
    var imgPoster:ImageView?=null
    var tabLayout:TabLayout?=null
    var movieId:String?=null
    var slogan:String?=null
    var viewPager:ViewPager?=null
    var anim:ImageView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        movieId = intent!!.extras?.getString("MovieId")
        val doc= fr.collection("movies").document(movieId!!)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        imgPoster = findViewById<ImageView>(R.id.poster)
         mvname = findViewById<TextView>(R.id.moviename)
         im_rate = findViewById<TextView>(R.id.ratings_im)
         kp_rate = findViewById<TextView>(R.id.ratings_kp)
         runtime = findViewById<TextView>(R.id.times)
         genview =  findViewById<TextView>(R.id.deliverytext)

        imgFullImage = findViewById(R.id.full_imageview)
        imgPoster?.setBackgroundResource(R.drawable.loadanim)
        imgBack = findViewById(R.id.img_back)

        tabLayout = findViewById<TabLayout>(R.id.food_details_tab_layout)
        tabLayout?.addTab(tabLayout?.newTab()!!.setText("Описание"))
        tabLayout?.tabGravity = TabLayout.GRAVITY_FILL
        anim = findViewById<ImageView>(R.id.animat)
        viewPager = findViewById<View>(R.id.food_view_pager) as ViewPager
        var anim1 = anim?.drawable as AnimationDrawable
        var anim2 = imgPoster?.background as AnimationDrawable
        anim1.start()
        anim2.start()

        GlobalScope.launch {
            doc.get().addOnCompleteListener() {
                val doc = it.result
                name = doc.getString("name")
                imgurl = doc.getString("imgurl")!!
                im = doc.getString("im_rate")
                kp = doc.getString("kp_rate")
                runt = doc.getString("runt")
                gen = doc.getString("genre")
                desc = doc.getString("desc")
                actor1 = doc.getString("actor1")
                actor2 = doc.getString("actor2")
                actor3 = doc.getString("actor3")
                director = doc.getString("director")
                slogan = doc.getString("slogan")
            }
            while (imgurl==null) {
                continue
            }
            getm(imgurl)
        }
        imgBack?.setOnClickListener(View.OnClickListener { finish() })


    }
    fun getm(imgurl:String?) {
        val getimg = GetRate()
        GlobalScope.launch {
            image = getimg.doInBackground(imgurl)
            withContext(Dispatchers.Main) {
                put(image)
            }
        }
    }
    public fun put(image:Bitmap?) {
        anim?.visibility = View.GONE
        imgPoster?.setImageBitmap(image)
        mvname?.setText(name)
        im_rate?.setText(im)
        kp_rate?.setText(kp)
        runtime?.setText(runt)
        genview?.setText(gen)
        val tabsAdapter = Main3TabsAdapter(supportFragmentManager, tabLayout!!.tabCount, desc, actor1, actor2, actor3, director, movieId, slogan)
        viewPager?.setAdapter(tabsAdapter);
    }
}