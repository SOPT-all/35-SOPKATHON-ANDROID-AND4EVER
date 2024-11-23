package org.sopt.and4ever.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class GetPingDetail(
    val situation: String,
    val ping: String,
    val pingStatus: String,
    val createdDate: String,
)
