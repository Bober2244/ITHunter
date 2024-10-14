package dev.bober.database.di

import androidx.room.Room
import dev.bober.database.db.AppDatabase
import dev.bober.database.repository.LocalRepositoryImpl
import dev.bober.domain.repository.LocalRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
    single { get<AppDatabase>().offerDao }
    single { get<AppDatabase>().vacancyDao }
    singleOf(::LocalRepositoryImpl) { bind<LocalRepository>() }
}