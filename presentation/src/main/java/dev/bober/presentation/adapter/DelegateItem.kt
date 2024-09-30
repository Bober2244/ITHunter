package dev.bober.presentation.adapter

interface DelegateItem {
    val id: Any
    override fun equals(other: Any?): Boolean
}