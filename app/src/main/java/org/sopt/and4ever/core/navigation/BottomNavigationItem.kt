package org.sopt.and4ever.core.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.sopt.and4ever.R

enum class BottomNavigationItem(
    @StringRes val titleRes: Int,
    @DrawableRes val iconRes: Int,
) {
    HOME(R.string.app_name , R.drawable.ic_launcher_background),
    MY_PING(R.string.app_name , R.drawable.ic_launcher_background),
    OTHER_PING(R.string.app_name , R.drawable.ic_launcher_background)
}