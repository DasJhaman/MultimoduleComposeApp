package de.multimodule.compposeapp.android

import android.app.Application
import android.content.Context
import de.multimodule.compposeapp.data.initKoin
import de.multimodule.compposeapp.presentation.MainViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(additionalModules = listOf(module {
            single<Context> { this@AppApplication }
            singleOf(::MainViewModel)
        }
        ))
    }
}