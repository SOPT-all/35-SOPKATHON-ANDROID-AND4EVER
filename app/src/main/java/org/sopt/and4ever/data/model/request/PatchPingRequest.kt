package org.sopt.and4ever.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class PatchPingRequest(
    val pingStatus: String,
)
