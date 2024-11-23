package org.sopt.and4ever.data.service

import org.sopt.and4ever.domain.model.MyPingList
import retrofit2.http.GET
import retrofit2.http.Query

interface MyPingService {

    @GET("pings/my")
    suspend fun fetchMyPingList(
        @Query("pingStatus") pingStatus: String
    ): MyPingList


}