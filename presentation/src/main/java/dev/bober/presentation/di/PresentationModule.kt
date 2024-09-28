package dev.bober.presentation.di

import dev.bober.presentation.favorite.FavoriteViewModel
import dev.bober.presentation.search.SearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { FavoriteViewModel() }
    viewModel { SearchViewModel() }

}