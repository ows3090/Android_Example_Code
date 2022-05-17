package ows.kotlinstudy.calculatorwithcleanarchitecture.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ows.kotlinstudy.mvcexample.model.db.ResultDatabase

val appModule = module{
    // DB
    single { ResultDatabase.build(androidContext()) }


}