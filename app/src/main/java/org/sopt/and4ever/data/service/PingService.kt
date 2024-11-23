package org.sopt.and4ever.data.service

import org.sopt.and4ever.data.model.request.PingRequest
import org.sopt.and4ever.data.model.request.SelectRequest
import org.sopt.and4ever.data.model.response.PingResponse
import org.sopt.and4ever.data.model.response.SelectPingResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface PingService {
    @POST("pings")
    suspend fun generatePing(
        @Body request: PingRequest
    ): PingResponse

    @POST("pings/select")
    suspend fun selectPing(
        @Body request: SelectRequest,
    ): SelectPingResponse
}
