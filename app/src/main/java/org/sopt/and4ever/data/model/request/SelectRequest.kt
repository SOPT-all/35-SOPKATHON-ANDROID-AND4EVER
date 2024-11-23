package org.sopt.and4ever.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SelectRequest(
    @SerialName("situation")
    val situation: String,
    @SerialName("ping")
    val ping: String
)
