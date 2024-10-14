package dev.bober.presentation.utils

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE

/**
 * @param field is a field that will checked by null
 * @param block is a block that will be applied after checking
 */
inline fun <T> View.checkField(field : Any?, block : () -> T) {
    if (field != null) {
        visibility = VISIBLE
        block()
    } else {
        visibility = GONE
    }
}
