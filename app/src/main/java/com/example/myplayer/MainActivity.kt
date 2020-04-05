package com.example.myplayer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Logger {

    val adapter = MediaAdapter(MediaProvider.data) { (id) -> navigateToDetail(id) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.adapter = adapter

        /*//implementing function of Logger interface
        d("Simple Logger Feature")*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.items_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.filter_all -> adapter.items = MediaProvider.data
            R.id.filter_photos -> {
                adapter.items =
                    MediaProvider.data.filter { it.type == MediaItem.Type.PHOTO }
                // adapter.items = filterItems
            }
            R.id.filter_videos -> {
                adapter.items =
                    MediaProvider.data.filter { it.type == MediaItem.Type.VIDEO }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun navigateToDetail(id: Int) {
        // startActivity()
        val detailActivity = Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.ID, id)
        }
        startActivity(detailActivity)
    }
}

interface Logger {
    val tag: String
        get() = javaClass.simpleName

    fun d(message: String) = Log.d(tag, message)
}
