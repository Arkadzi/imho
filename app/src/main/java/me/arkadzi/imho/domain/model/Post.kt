package me.arkadzi.imho.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
        var userId: Int,
        var id: Int,
        var title: String,
        var body: String
) : Parcelable