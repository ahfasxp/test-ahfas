package com.ahfasxp.testahfas.core.utils

import com.ahfasxp.testahfas.core.data.source.remote.response.DataMateri
import com.ahfasxp.testahfas.core.data.source.remote.response.DataTryout
import com.ahfasxp.testahfas.core.data.source.remote.response.DataUser
import com.ahfasxp.testahfas.core.domain.model.Materi
import com.ahfasxp.testahfas.core.domain.model.Tryout
import com.ahfasxp.testahfas.core.domain.model.User

object DataMapper {
    fun mapResponsesToDomainMateriList(it: List<DataMateri>): List<Materi> =
        it.map {
            Materi(
                name = it.name,
                id = it.id,
                createdBy = it.createdBy,
                content = it.content
            )
        }

    fun mapResponsesToDomainTryoutList(it: List<DataTryout>): List<Tryout> =
        it.map {
            Tryout(
                name = it.name,
                id = it.id,
                createdBy = it.createdBy,
                description = it.description,
                time = it.time
            )
        }

    fun mapResponsesToDomainUser(it: DataUser) = User(
        id = it.id, name = it.name, email = it.email, apiToken = it.apiToken
    )

    fun mapResponsesToDomainMateri(it: DataMateri) = Materi(
        name = it.name,
        id = it.id,
        createdBy = it.createdBy,
        content = it.content
    )

    fun mapResponsesToDomainTryout(it: DataTryout) = Tryout(
        name = it.name,
        id = it.id,
        createdBy = it.createdBy,
        description = it.description,
        time = it.time
    )
}