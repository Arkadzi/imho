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

    @GET("labs/{labId}/priorities")
    fun getLabPriorities(@Path("labId") labId: Long): Single<List<LabPriority>>

    @GET("labs/{labId}/lecturers")
    fun getLecturersByLab(@Path("labId") labId: Long): Single<List<Lecturer>>

    @GET("lecturers/{lectId}/labs")
    fun getLabsByLecturers(@Path("lectId") lectId: Long): Single<List<Lab>>

    @GET("graduateWorks/own")
    fun getOwnGraduateWorks(@Query("userId") userId: Long): Single<List<GraduateWork>>

    @GET("graduateWorks/offered")
    fun getOfferedGraduateWorks(@Query("userId") userId: Long): Single<List<GraduateWork>>

    @POST("graduateWorks")
    fun createGraduateWork(@Body graduateWork: GraduateWork): Single<ResponseBody>

    @GET("priorities/{priorityId}")
    fun getLabAndPriorities(@Path("priorityId") priorityId: Long): Single<LabAndPriority>

    @POST("graduateWorks/offer")
    fun offerWork(
            @Query("workId") workId: Long,
            @Query("userId") userId: Long,
            @Query("cancel") cancel: Boolean
    ): Single<ResponseBody>

}
