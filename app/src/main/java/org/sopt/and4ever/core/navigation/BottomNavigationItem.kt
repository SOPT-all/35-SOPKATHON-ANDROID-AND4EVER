package org.sopt.and4ever.core.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.sopt.and4ever.R

enum class BottomNavigationItem(
    @DrawableRes val iconRes: Int,
) {
    OTHER_PING(R.drawable.ic_fire),
    HOME(R.drawable.ic_home),
    MY_PING(R.drawable.ic_list)
}