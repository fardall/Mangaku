package com.mangaku

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Manga (
    var title: String,
    var author: String,
    var genre: String,
    var summary: String,
    var avatar: Int
) : Parcelable