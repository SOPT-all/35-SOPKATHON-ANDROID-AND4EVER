package org.sopt.and4ever.domain.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Serializable
@Immutable
data class MyPingList(
    val pingList: List<MyPing>
)

@Serializable
data class MyPing(
    val pingId: Int,
    val ping: String,
    val createdDate: String,
    val pingStatus: String,
)