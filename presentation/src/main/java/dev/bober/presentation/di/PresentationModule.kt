package dev.bober.presentation.di

import dev.bober.presentation.favorite.FavoriteViewModel
import dev.bober.presentation.search.SearchViewModel
import org.koin.core.definition.Definition
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {

    viewModelOf(::FavoriteViewModel)
    viewModelOf(::SearchViewModel)
}