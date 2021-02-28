package com.ahfasxp.testahfas.core.data.source.remote.network

import com.ahfasxp.testahfas.core.data.source.remote.response.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    /// USER ///
    @FormUrlEncoded
    @POST("register")
    fun postRegister(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<RegistrasiUser>

    @FormUrlEncoded
    @POST("login")
    fun postLogin(
        @Field("email") name: String,
        @Field("password") password: String
    ): Call<LoginUser>

    @Headers("Authorization: Bearer {api_token}")
    @POST("logout")
    fun postLogout(
        @Path("api_token") apiToken: String
    ): Call<LogoutUser>


    /// MATERI ///
    @GET("materies")
    fun getMateries(): Call<MateriResponse>

    @FormUrlEncoded
    @Headers("Authorization: Bearer {api_token}")
    @POST("materies")
    fun storeMateri(
        @Path("api_token") apiToken: String,
        @Field("name") name: String,
        @Field("content") content: String,
        @Field("created_by") createdBy: Int
    ): Call<StoreMateri>

    @FormUrlEncoded
    @Headers("Authorization: Bearer {api_token}")
    @PUT("materies/{id}")
    fun updateMateri(
        @Path("api_token") apiToken: String,
        @Path("id") id: Int,
        @Field("name") name: String,
        @Field("content") content: String,
    ): Call<UpdateMateri>

    @FormUrlEncoded
    @Headers("Authorization: Bearer {api_token}")
    @DELETE("materies/{id}")
    fun destroyMateri(
        @Path("api_token") apiToken: String,
        @Path("id") id: Int
    ): Call<DestroyMateri>


    /// TRYOUT ///
    @GET("tryouts")
    fun gettryouts(): Call<TryoutResponse>

    @FormUrlEncoded
    @Headers("Authorization: Bearer {api_token}")
    @POST("tryouts")
    fun storeTryout(
        @Path("api_token") apiToken: String,
        @Field("name") name: String,
        @Field("description") content: String,
        @Field("time") time: String,
        @Field("created_by") createdBy: Int
    ): Call<StoreTryout>

    @FormUrlEncoded
    @Headers("Authorization: Bearer {api_token}")
    @PUT("tryouts/{id}")
    fun updateTryout(
        @Path("api_token") apiToken: String,
        @Path("id") id: Int,
        @Field("name") name: String,
        @Field("description") content: String,
        @Field("time") time: String
    ): Call<UpdateTryout>

    @FormUrlEncoded
    @Headers("Authorization: Bearer {api_token}")
    @DELETE("tryouts/{id}")
    fun destroyTryout(
        @Path("api_token") apiToken: String,
        @Path("id") id: Int
    ): Call<DestroyTryout>
}