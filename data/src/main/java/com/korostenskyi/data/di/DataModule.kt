package com.korostenskyi.data.di

import com.korostenskyi.data.network.MoviesApiDataSourceImpl
import com.korostenskyi.data.network.MoviesApiDataSource
import com.korostenskyi.data.network.api.ApiClientFactory
import com.korostenskyi.data.repository.MovieRepositoryImpl
import com.korostenskyi.domain.repository.MovieRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {

    single { ApiClientFactory.createClient(get(named("tmdbBaseUrl"))) }

    single<MoviesApiDataSource> { MoviesApiDataSourceImpl(get(), get(named("tmdbApiKey")))}

    single<MovieRepository> { MovieRepositoryImpl(get()) }
}