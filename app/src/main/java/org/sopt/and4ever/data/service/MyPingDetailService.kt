package org.sopt.and4ever.data.service

import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.Path

interface MyPingDetailService {
    @PATCH("pings/")
    suspend fun patchPingStatus(
        @Path("pingId") pingId: Int,
        @Body pingStatus: String,
    ): String
}