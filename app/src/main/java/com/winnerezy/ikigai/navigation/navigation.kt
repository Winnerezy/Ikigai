package com.winnerezy.ikigai.navigation

sealed class Navigation(val route: String) {
    object LandingPage : Navigation("Landing")
}