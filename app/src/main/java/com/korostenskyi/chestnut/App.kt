package com.korostenskyi.chestnut

import android.app.Application
import coil.util.CoilLogger
import com.korostenskyi.chestnut.di.appModule
import com.korostenskyi.data.di.dataModule
import com.korostenskyi.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        CoilLogger.setEnabled(true)
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}