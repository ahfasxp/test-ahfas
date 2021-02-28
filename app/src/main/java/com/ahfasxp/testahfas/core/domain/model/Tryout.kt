package com.ahfasxp.testahfas.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tryout(
    val name: String,
    val id: Int,
    val createdBy: Int,
    val description: String,
    val time: String
) : Parcelable