package com.example.myplayer

private val thumbBase = "http://lorempixel.com/400/400/cats/"

object MediaProvider {
    // Using Collections
    val data = (1..10).map {
        MediaItem(
            it,
            "Title $it",
            "$thumbBase$it",
            if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO
        )
    }
}

