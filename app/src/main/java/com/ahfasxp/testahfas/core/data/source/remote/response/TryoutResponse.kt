package com.ahfasxp.testahfas.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TryoutResponse(
    @field:SerializedName("data")
    val data: List<DataTryout>,

    @field:SerializedName("message")
    val massage: String,

    @field:SerializedName("status")
    val status: String
)

data class StoreTryout(
    @field:SerializedName("data")
    val data: DataTryout,

    @field:SerializedName("message")
    val massage: String,

    @field:SerializedName("status")
    val status: String
)

data class UpdateTryout(
    @field:SerializedName("data")
    val data: DataTryout,

    @field:SerializedName("message")
    val massage: String,

    @field:SerializedName("status")
    val status: String
)

data class DestroyTryout(
    @field:SerializedName("data")
    val data: DataTryout,

    @field:SerializedName("message")
    val massage: String,

    @field:SerializedName("status")
    val status: String
)

data class DataTryout(
    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("created_by")
    val createdBy: Int,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("time")
    val time: String
)