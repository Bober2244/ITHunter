package dev.bober.domain.di

import dev.bober.domain.usecase.AddFavoriteUseCase
import dev.bober.domain.usecase.GetDataUseCase
import dev.bober.domain.usecase.GetFavoritesCountUseCase
import dev.bober.domain.usecase.GetVacanciesUseCase
import dev.bober.domain.usecase.RemoveFavoriteUseCase
import dev.bober.domain.usecase.SaveDataUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {

    factoryOf(::GetVacanciesUseCase)
    factoryOf(::GetDataUseCase)
    factory{ SaveDataUseCase(get()) }
    factoryOf(::AddFavoriteUseCase)
    factoryOf(::RemoveFavoriteUseCase)
    factoryOf(::GetFavoritesCountUseCase)
}