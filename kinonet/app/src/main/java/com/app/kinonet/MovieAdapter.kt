package com.app.kinonet

import android.app.Activity
import android.widget.ArrayAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView

class MovieAdapter(context: Activity?, androidFlavors: List<Movie?>?) : ArrayAdapter<Movie?>(
    context!!, 0, androidFlavors!!
) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Check if the existing view is being reused, otherwise inflate the view
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                R.layout.list_item, parent, false
            )
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        val curr_movie = getItem(position)

        // Find the TextView in the list_item.xml layout with the ID version_name
        val moviename = listItemView!!.findViewById<View>(R.id.book_title) as TextView
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        moviename.text = curr_movie!!.name

        // Find the TextView in the list_item.xml layout with the ID version_number
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        val resizedimg = Bitmap.createScaledBitmap(curr_movie.image, 80, 80, true)
        val img = listItemView.findViewById<View>(R.id.cover_image) as ImageView
        img.setImageBitmap(resizedimg)
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView
    }
}