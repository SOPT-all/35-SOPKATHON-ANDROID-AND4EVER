package org.sopt.and4ever.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Route {
    @Serializable
    data object Home: Route

    @Serializable
    data object Input: Route

    @Serializable
    data object Result: Route

    @Serializable
    data object MyPing: Route

    @Serializable
    data class MyPingDetail(val id: Int): Route

    @Serializable
    data object OtherPing: Route
}