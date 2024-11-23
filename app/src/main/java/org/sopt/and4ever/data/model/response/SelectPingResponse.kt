package org.sopt.and4ever.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SelectPingResponse(
    @SerialName("message")
    val message: String
)