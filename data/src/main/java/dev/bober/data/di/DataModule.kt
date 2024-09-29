package dev.bober.data.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import dev.bober.data.api.Api
import dev.bober.data.repository.ResponseRepositoryImpl
import dev.bober.domain.repository.ResponseRepository
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .build()
    }
    single {
        get<Retrofit>().create(Api::class.java)
    }
    single {
        OkHttpClient.Builder()
            .cache(get())
            .build()
    }

    single { GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create() }
    single { Cache(androidApplication().cacheDir, 10L * 1024 * 1024) }

    singleOf(::ResponseRepositoryImpl) { bind<ResponseRepository>() }
}

private const val BASE_URL = "https://drive.usercontent.google.com/u/0/uc"