package dev.bober.presentation.di

import dev.bober.presentation.screens.favorite.FavoriteViewModel
import dev.bober.presentation.screens.search.SearchViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {

    viewModelOf(::FavoriteViewModel)
    viewModelOf(::SearchViewModel)
}