package com.ahfasxp.testahfas.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MateriResponse(
    @field:SerializedName("data")
    val data: List<DataMateri>,

    @field:SerializedName("message")
    val massage: String,

    @field:SerializedName("status")
    val status: String
)

data class StoreMateri(
    @field:SerializedName("data")
    val data: DataMateri,

    @field:SerializedName("message")
    val massage: String,

    @field:SerializedName("status")
    val status: String
)

data class UpdateMateri(
    @field:SerializedName("data")
    val data: DataMateri,

    @field:SerializedName("message")
    val massage: String,

    @field:SerializedName("status")
    val status: String
)

data class DestroyMateri(
    @field:SerializedName("data")
    val data: DataMateri,

    @field:SerializedName("message")
    val massage: String,

    @field:SerializedName("status")
    val status: String
)

data class DataMateri(
    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("created_by")
    val createdBy: Int,

    @field:SerializedName("content")
    val content: String
)