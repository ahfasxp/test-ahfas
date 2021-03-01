package com.ahfasxp.testahfas.core.utils

import com.ahfasxp.testahfas.core.data.source.remote.response.DataMateri
import com.ahfasxp.testahfas.core.data.source.remote.response.DataTryout
import com.ahfasxp.testahfas.core.domain.model.Materi
import com.ahfasxp.testahfas.core.domain.model.Tryout

object DataMapper {
    fun mapResponsesToDomainTryout(it: List<DataTryout>): List<Tryout> =
        it.map {
            Tryout(
                name = it.name,
                id = it.id,
                createdBy = it.createdBy,
                description = it.description,
                time = it.time
            )
        }

    fun mapResponsesToDomainMateri(it: List<DataMateri>): List<Materi> =
        it.map {
            Materi(
                name = it.name,
                id = it.id,
                createdBy = it.createdBy,
                content = it.content
            )
        }
}