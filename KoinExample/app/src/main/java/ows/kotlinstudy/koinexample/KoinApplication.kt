package ows.kotlinstudy.koinexample

import android.app.Application
import ows.kotlinstudy.koinexample.data.startLiteKoin
import ows.kotlinstudy.koinexample.di.mod1
import ows.kotlinstudy.koinexample.di.mod2

class KoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startLiteKoin {
            modules(mod1 + mod2)
        }
    }
}