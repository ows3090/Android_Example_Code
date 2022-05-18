package ows.kotlinstudy.calculatorwithcleanarchitecture

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ows.kotlinstudy.calculatorwithcleanarchitecture.di.appModule


class CalculatorApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@CalculatorApplication)
            modules(appModule)
        }
    }
}