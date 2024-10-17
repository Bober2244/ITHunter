package dev.bober.utils

import com.google.android.material.bottomnavigation.BottomNavigationView

fun BottomNavigationView.setupBadge(id: Int, number: Int) {
    this.getOrCreateBadge(id).number = number
}