package dev.bober.domain.di

import dev.bober.domain.usecase.GetDataUseCase
import dev.bober.domain.usecase.GetOffersUseCase
import dev.bober.domain.usecase.GetVacanciesUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {

    factoryOf(::GetOffersUseCase)
    factoryOf(::GetVacanciesUseCase)
    factoryOf(::GetDataUseCase)
}