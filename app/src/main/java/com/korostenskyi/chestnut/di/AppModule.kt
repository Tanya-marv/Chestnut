package com.korostenskyi.chestnut.di

import com.korostenskyi.chestnut.BuildConfig
import com.korostenskyi.chestnut.ui.movies.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    viewModel { MoviesViewModel(get()) }
    single(named("tmdbApiKey")) { BuildConfig.TMDB_API_KEY }
    single(named("tmdbBaseUrl")) { BuildConfig.TMDB_BASE_URL }
}