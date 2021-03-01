package com.ahfasxp.testahfas.core.utils

import com.ahfasxp.testahfas.core.data.source.remote.response.DataTryout
import com.ahfasxp.testahfas.core.domain.model.Tryout

object DataMapper {
    fun mapResponsesToDomain(it: List<DataTryout>): List<Tryout> =
        it.map {
            Tryout(
                name = it.name,
                id = it.id,
                createdBy = it.createdBy,
                description = it.description,
                time = it.time
            )
        }
}