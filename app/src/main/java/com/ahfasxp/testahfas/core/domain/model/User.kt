package com.ahfasxp.testahfas.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Int,
    val name: String,
    val email: String,
    val apiToken: String? = null
) : Parcelable