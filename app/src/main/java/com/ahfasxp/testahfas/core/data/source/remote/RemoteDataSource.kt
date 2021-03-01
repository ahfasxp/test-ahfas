package com.ahfasxp.testahfas.core.data.source.remote

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ahfasxp.testahfas.core.data.source.remote.network.ApiResponse
import com.ahfasxp.testahfas.core.data.source.remote.network.ApiService
import com.ahfasxp.testahfas.core.data.source.remote.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }


    /// USER ///
    fun postRegister(
        name: String,
        email: String,
        password: String
    ): LiveData<ApiResponse<DataUser>> {
        val resultData = MutableLiveData<ApiResponse<DataUser>>()

        //get data from remote api
        val client = apiService.postRegister(name, email, password)
        client.enqueue(object : Callback<RegistrasiUser> {
            override fun onResponse(
                call: Call<RegistrasiUser>,
                response: Response<RegistrasiUser>
            ) {
                val data = response.body()?.data
                resultData.value =
                    if (data != null) ApiResponse.Success(data) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<RegistrasiUser>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }

    fun postLogin(
        email: String,
        password: String
    ): LiveData<ApiResponse<DataUser>> {
        val resultData = MutableLiveData<ApiResponse<DataUser>>()

        //get data from remote api
        val client = apiService.postLogin(email, password)
        client.enqueue(object : Callback<LoginUser> {
            override fun onResponse(
                call: Call<LoginUser>,
                response: Response<LoginUser>
            ) {
                val data = response.body()?.data
                resultData.value =
                    if (data != null) ApiResponse.Success(data) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<LoginUser>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }

    fun postLogout(
        apiToken: String
    ): LiveData<ApiResponse<DataUser>> {
        val resultData = MutableLiveData<ApiResponse<DataUser>>()

        //get data from remote api
        val client = apiService.postLogout(apiToken)
        client.enqueue(object : Callback<LogoutUser> {
            override fun onResponse(
                call: Call<LogoutUser>,
                response: Response<LogoutUser>
            ) {
                val data = response.body()?.data
                resultData.value =
                    if (data != null) ApiResponse.Success(data) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<LogoutUser>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }


    /// MATERI ///
    fun getMateries(): LiveData<List<DataMateri>> {
        val resultData = MutableLiveData<List<DataMateri>>()

        //get data from remote api
        val client = apiService.getMateries()
        client.enqueue(object : Callback<MateriResponse> {
            override fun onResponse(
                call: Call<MateriResponse>,
                response: Response<MateriResponse>
            ) {
                if (response.isSuccessful) {
                    resultData.value = response.body()?.data
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MateriResponse>, t: Throwable) {
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }

    fun storeMateri(
        apiToken: String,
        name: String,
        content: String,
        createdBy: Int
    ): LiveData<ApiResponse<DataMateri>> {
        val resultData = MutableLiveData<ApiResponse<DataMateri>>()

        //get data from remote api
        val client = apiService.storeMateri(apiToken, name, content, createdBy)
        client.enqueue(object : Callback<StoreMateri> {
            override fun onResponse(
                call: Call<StoreMateri>,
                response: Response<StoreMateri>
            ) {
                val data = response.body()?.data
                resultData.value =
                    if (data != null) ApiResponse.Success(data) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<StoreMateri>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }

    fun updateMateri(
        apiToken: String,
        id: Int,
        name: String,
        content: String
    ): LiveData<ApiResponse<DataMateri>> {
        val resultData = MutableLiveData<ApiResponse<DataMateri>>()

        //get data from remote api
        val client = apiService.updateMateri(apiToken, id, name, content)
        client.enqueue(object : Callback<UpdateMateri> {
            override fun onResponse(
                call: Call<UpdateMateri>,
                response: Response<UpdateMateri>
            ) {
                val data = response.body()?.data
                resultData.value =
                    if (data != null) ApiResponse.Success(data) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<UpdateMateri>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }

    fun destroyMateri(
        apiToken: String,
        id: Int
    ): LiveData<ApiResponse<DataMateri>> {
        val resultData = MutableLiveData<ApiResponse<DataMateri>>()

        //get data from remote api
        val client = apiService.destroyMateri(apiToken, id)
        client.enqueue(object : Callback<DestroyMateri> {
            override fun onResponse(
                call: Call<DestroyMateri>,
                response: Response<DestroyMateri>
            ) {
                val data = response.body()?.data
                resultData.value =
                    if (data != null) ApiResponse.Success(data) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<DestroyMateri>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }


    /// TRYOUT ///
    fun getTryouts(): LiveData<List<DataTryout>> {
        val resultData = MutableLiveData<List<DataTryout>>()

        //get data from remote api
        val client = apiService.gettryouts()
        client.enqueue(object : Callback<TryoutResponse> {
            override fun onResponse(
                call: Call<TryoutResponse>,
                response: Response<TryoutResponse>
            ) {
                if (response.isSuccessful) {
                    resultData.value = response.body()?.data
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TryoutResponse>, t: Throwable) {
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }

    fun storeTryout(
        apiToken: String,
        name: String,
        description: String,
        time: String,
        createdBy: Int
    ): LiveData<ApiResponse<DataTryout>> {
        val resultData = MutableLiveData<ApiResponse<DataTryout>>()

        //get data from remote api
        val client = apiService.storeTryout(apiToken, name, description, time, createdBy)
        client.enqueue(object : Callback<StoreTryout> {
            override fun onResponse(
                call: Call<StoreTryout>,
                response: Response<StoreTryout>
            ) {
                val data = response.body()?.data
                resultData.value =
                    if (data != null) ApiResponse.Success(data) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<StoreTryout>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }

    fun updateTryout(
        apiToken: String,
        id: Int,
        name: String,
        description: String,
        time: String
    ): LiveData<ApiResponse<DataTryout>> {
        val resultData = MutableLiveData<ApiResponse<DataTryout>>()

        //get data from remote api
        val client = apiService.updateTryout(apiToken, id, name, description, time)
        client.enqueue(object : Callback<UpdateTryout> {
            override fun onResponse(
                call: Call<UpdateTryout>,
                response: Response<UpdateTryout>
            ) {
                val data = response.body()?.data
                resultData.value =
                    if (data != null) ApiResponse.Success(data) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<UpdateTryout>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }

    fun destroyTryout(
        apiToken: String,
        id: Int
    ): LiveData<ApiResponse<DataTryout>> {
        val resultData = MutableLiveData<ApiResponse<DataTryout>>()

        //get data from remote api
        val client = apiService.destroyTryout(apiToken, id)
        client.enqueue(object : Callback<DestroyTryout> {
            override fun onResponse(
                call: Call<DestroyTryout>,
                response: Response<DestroyTryout>
            ) {
                val data = response.body()?.data
                resultData.value =
                    if (data != null) ApiResponse.Success(data) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<DestroyTryout>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }
}
