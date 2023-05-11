package com.bangkit.jetpackandroid

val HOME = "home"
val DETAIL = "detail"
val ABOUT = "about"
val ID = "artist_id"
sealed class Screen(val route: String) {
    object Home: Screen(HOME)
    object Detail: Screen(DETAIL+"/{$ID}") {
        fun createRoute(id: Int) = DETAIL+"/$id"
    }

    object About: Screen(ABOUT)
}