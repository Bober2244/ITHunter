package dev.bober.ithunter

import android.app.Application
import dev.bober.data.di.dataModule
import dev.bober.database.di.databaseModule
import dev.bober.domain.di.domainModule
import dev.bober.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                databaseModule,
                dataModule,
                domainModule,
                presentationModule,
            )
        }
    }
}