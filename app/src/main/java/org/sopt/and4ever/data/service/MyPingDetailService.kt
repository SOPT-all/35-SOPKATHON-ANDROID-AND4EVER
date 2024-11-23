package org.sopt.and4ever.data.service

import org.sopt.and4ever.data.model.request.PatchPingRequest
import org.sopt.and4ever.data.model.response.GetPingDetail
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface MyPingDetailService {
    @PATCH("pings/{pingId}")
    suspend fun patchPingStatus(
        @Path("pingId") pingId: Int,
        @Body pingStatus: PatchPingRequest,
    )

    @GET("pings/{pingId}")
    suspend fun getPingDetail(
        @Path("pingId") pingId: Int,
    ): GetPingDetail
}