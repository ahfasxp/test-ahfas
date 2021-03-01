package com.ahfasxp.testahfas.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Materi(
    val name: String,
    val id: Int,
    val createdBy: Int,
    val content: String
) : Parcelable