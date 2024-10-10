package dev.bober.database.di

import androidx.room.Room
import dev.bober.database.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
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
}