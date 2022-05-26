package com.app.kinonet

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

import org.jsoup.Jsoup
import java.io.IOException
import java.net.URL
import java.util.ArrayList

class GetRate {
    suspend fun doInBackground(url:String?): Bitmap? {
            var img: Bitmap? =null
            try {
               val con =  BitmapFactory.decodeStream(URL(url).openConnection().getInputStream())
                img = con

            } catch (e: IOException) {
                e.printStackTrace()
            }
        return img
    }
}