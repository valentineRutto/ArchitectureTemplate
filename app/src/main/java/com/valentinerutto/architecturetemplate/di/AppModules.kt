package com.valentinerutto.architecturetemplate.di

import com.valentinerutto.architecturetemplate.api.ApiService
import com.valentinerutto.architecturetemplate.api.RetrofitClient.createOkClient
import com.valentinerutto.architecturetemplate.api.RetrofitClient.createRetrofit
import com.valentinerutto.architecturetemplate.data.DogImageRepository
import com.valentinerutto.architecturetemplate.ui.DogImageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModules = module{

    single<ApiService>{(get() as Retrofit).create(ApiService::class.java)}
    single{createOkClient()}

    single {
        createRetrofit(baseUrl = "https://dog.ceo/", get())
    }

    single { DogImageRepository(apiService = get()) }

    viewModel{ DogImageViewModel(get())}
}