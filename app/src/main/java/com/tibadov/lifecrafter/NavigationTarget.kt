package com.tibadov.lifecrafter

enum class NavigationTarget(val route: String) {
    Main("main"),
    Settings("settings");

    companion object {
        fun fromRoute(route: String): NavigationTarget? {
            return values().firstOrNull { it.route == route }
        }
    }
}
