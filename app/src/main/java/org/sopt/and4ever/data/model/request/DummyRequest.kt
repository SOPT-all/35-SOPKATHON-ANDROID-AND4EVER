package org.sopt.and4ever.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyRequest(
    @SerialName("id")
    val id: String,
)
