package dev.bober.data.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import dev.bober.data.Api
import dev.bober.data.repository.ResponseRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    single {
        get<Retrofit>().create(Api::class.java)
    }

    single { GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create() }

    singleOf(::ResponseRepositoryImpl)
}

private const val BASE_URL = "https://drive.usercontent.google.com/u/0/uc"