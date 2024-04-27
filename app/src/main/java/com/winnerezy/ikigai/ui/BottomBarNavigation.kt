package com.winnerezy.ikigai.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.winnerezy.ikigai.R
sealed class BottomBarNavigation(val route: String, @StringRes val resourceId: Int, @DrawableRes val Icon: Int, @DrawableRes val SelectedIcon: Int) {
    object Library: BottomBarNavigation("Library", R.string.navigation_library, R.drawable.ic_outline_library, R.drawable.ic_filled_library )
    object Updates: BottomBarNavigation("Updates", R.string.navigation_updates, R.drawable.ic_outline_updates, R.drawable.ic_filled_updates )
    object Explore: BottomBarNavigation("Explore", R.string.navigation_explore, R.drawable.ic_outline_explore, R.drawable.ic_filled_explore )
    object Profile: BottomBarNavigation("Profile", R.string.navigation_profile, R.drawable.ic_outline_profile, R.drawable.ic_filled_profile )
}