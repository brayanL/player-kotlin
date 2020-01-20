package com.example.myplayer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

// Adding default params
fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun RecyclerView.ViewHolder.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    itemView.context.toast(message, length)
}

// Inflate layout, this refer to object that using
fun ViewGroup.inflate(layout: Int): View {
    return LayoutInflater.from(context).inflate(layout, this, false)
}

// Load image using Picasso
fun ImageView.loadUrl(url: String) {
    Picasso.with(context).load(url).into(this)
}

// find View like findViewByID
inline fun <reified T: View> View.find(idRes: Int): T {
    return findViewById(idRes) as T
}

// find View on ViewHolder using another extension function
inline fun <reified T: View> RecyclerView.ViewHolder.find(idRes: Int): T {
    // return findViewById(idRes) as T
    return itemView.find(idRes)
}

