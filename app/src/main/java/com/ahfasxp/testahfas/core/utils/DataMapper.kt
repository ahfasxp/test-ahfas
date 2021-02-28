package com.ahfasxp.testahfas.core.utils

import com.ahfasxp.testahfas.core.data.source.remote.network.ApiResponse
import com.ahfasxp.testahfas.core.data.source.remote.response.DataTryout
import com.ahfasxp.testahfas.core.domain.model.Tryout

object DataMapper {
//    fun mapResponsesTomain(input: List<DataTryout>): List<Tryout> =
//        input.map {
//            Tryout(
//                name = it.name,
//                id = it.id,
//                createdBy = it.createdBy,
//                description = it.description,
//                time = it.time
//            )
//        }
//
//    fun mapResponsesToDomain(it: ApiResponse<List<DataTryout>>?) {
//        val Tryout = ArrayList<Tryout>()
//        Tryout(it)
//    }
//
//    fun mapResponsesToDomain(input: ApiResponse<List<DataTryout>>?) = Tryout(
//        name =input.name
//
//    )
//    fun mapResponsesToEntities(input: List<TourismResponse>): List<TourismEntity> {
//        val tourismList = ArrayList<TourismEntity>()
//        input.map {
//            val tourism = TourismEntity(
//                tourismId = it.id,
//                description = it.description,
//                name = it.name,
//                address = it.address,
//                latitude = it.latitude,
//                longitude = it.longitude,
//                like = it.like,
//                image = it.image,
//                isFavorite = false
//            )
//            tourismList.add(tourism)
//        }
//        return tourismList
//    }
}