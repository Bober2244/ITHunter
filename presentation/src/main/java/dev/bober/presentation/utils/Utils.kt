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
/**
 * @param number is a number that will be checked
 */
fun checkNumbers(number: Int): String {
    return if (number % 10 == 1) "$number вакансия"
    else if (number % 10 in 2..4) "$number вакансии"
    else "$number вакансий"
}
