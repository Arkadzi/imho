package me.arkadzi.imho.data.rest

import io.reactivex.Single
import me.arkadzi.imho.domain.model.*
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface RetrofitApi {
    @GET("users/self")
    fun getSelf(@Header("Authorization") token: String): Single<User>

    @POST("login")
    fun login(@Body credentials: Credentials): Single<Response<ResponseBody>>

    @GET("labs")
    fun getLabs(): Single<List<Lab>>

    @GET("lecturers")
    fun getLecturers(): Single<List<Lecturer>>

    @GET("labs/{userId}/priorities")
    fun getLabPriorities(@Path("userId") labId: Long): Single<List<LabPriority>>

    @GET("labs/{userId}/lecturers")
    fun getLecturersByLab(@Path("userId") labId: Long): Single<List<Lecturer>>
}
