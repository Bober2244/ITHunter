package dev.bober.utils

import com.google.android.material.bottomnavigation.BottomNavigationView

fun badgeSetup(navView : BottomNavigationView, id: Int, number: Int) {
    navView.getOrCreateBadge(id).apply {
        isVisible = true
        this.number = number
    }
}

fun badgeClear(navView : BottomNavigationView, id: Int) {
    navView.getBadge(id)?.let {
        it.apply {
            isVisible = false
            clearNumber()
        }
    }
}