package me.arkadzi.imho.data.rest

import io.reactivex.Single
import me.arkadzi.imho.domain.model.Credentials
import me.arkadzi.imho.domain.model.Lab
import me.arkadzi.imho.domain.model.Lecturer
import me.arkadzi.imho.domain.model.User
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface RetrofitApi {
    @GET("users/self")
    fun getSelf(@Header("Authorization") token: String): Single<User>

    @POST("login")
    fun login(@Body credentials: Credentials): Single<Response<ResponseBody>>

    @GET("labs")
    fun getLabs(): Single<List<Lab>>

    @GET("lecturers")
    fun getLecturers(): Single<List<Lecturer>>
}
