package org.sopt.and4ever.core.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.sopt.and4ever.R

enum class BottomNavigationItem(
    @StringRes val titleRes: Int,
    @DrawableRes val iconRes: Int,
) {
    HOME(R.string.app_name , R.drawable.ic_home),
    MY_PING(R.string.app_name , R.drawable.ic_list),
    OTHER_PING(R.string.app_name , R.drawable.ic_fire)
}