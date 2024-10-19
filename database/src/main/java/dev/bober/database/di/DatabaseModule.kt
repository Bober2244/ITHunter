package dev.bober.database.di

import androidx.room.Room
import dev.bober.database.converter.Converters
import dev.bober.database.db.AppDatabase
import dev.bober.database.db.MIGRATION_1_2
import dev.bober.database.repository.LocalRepositoryImpl
import dev.bober.domain.repository.LocalRepository
import kotlinx.serialization.json.Json
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
        )
            .addTypeConverter(Converters(get<Json>()))
            .addMigrations(MIGRATION_1_2)
            .build()
    }
    single { get<AppDatabase>().offerDao }
    single { get<AppDatabase>().vacancyDao }
    singleOf(::LocalRepositoryImpl) { bind<LocalRepository>() }

    single {
        Json {
            ignoreUnknownKeys = true
        }
    }
}