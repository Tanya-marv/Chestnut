package com.korostenskyi.domain.di

import com.korostenskyi.domain.interactor.MovieInteractor
import com.korostenskyi.domain.interactor.MovieInteractorImpl
import org.koin.dsl.module

val domainModule = module {
    single<MovieInteractor> { MovieInteractorImpl(get()) }
}