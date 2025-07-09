package com.sam.navigationincompose.navigation

import com.sam.navigationincompose.R

enum class NavDestination {
    Home,
    Detail
}

sealed interface SealedNavDestination{
    val route: String
    val title: String


    data class Home(
        val selectedIconId: Int,
        val unselectedIconId: Int
    ): SealedNavDestination{
        override val route: String
            get() = "home"
        override val title: String
            get() = "Home"
    }
    data class Detail(
        val selectedIconId: Int,
        val unselectedIconId: Int
    ): SealedNavDestination{
        override val route: String
            get() = "detail"
        override val title: String
            get() = "Detail"
    }
    data object Setting: SealedNavDestination{
        override val route: String
            get() = "detail"
        override val title: String
            get() = "Detail"

    }


}