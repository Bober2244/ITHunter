package dev.bober.domain.di

import dev.bober.domain.repository.ResponseRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::ResponseRepositoryImpl) { bind<ResponseRepository>() }
}