package com.example.myplayer

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

//MediaAdapter receive list of items and lambada function
class MediaAdapter(items: List<MediaItem>, val listener: (MediaItem) -> Unit) :
    RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    //if the items change notifyDataSetChanged is called
    var items: List<MediaItem> by Delegates.observable(items) { _, _, _ ->
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = parent.inflate(R.layout.view_media_item)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        //setOnClickListener register a callback the which was passed as parameter on MediaAdapter constructor
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = find<TextView>(R.id.media_title)
        val image = find<ImageView>(R.id.media_thumb)
        val videoIndicator = find<ImageView>(R.id.media_video_indicator)

        fun bind(item: MediaItem) {
            title.text = item.title
            image.loadUrl(item.thumbUrl)
            videoIndicator.visibility = when (item.type) {
                MediaItem.Type.VIDEO -> View.VISIBLE
                MediaItem.Type.PHOTO -> View.GONE
            }
        }
    }
}