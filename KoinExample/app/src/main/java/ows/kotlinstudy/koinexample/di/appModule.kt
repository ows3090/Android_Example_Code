package ows.kotlinstudy.koinexample.di

import ows.kotlinstudy.koinexample.Repository
import ows.kotlinstudy.koinexample.UseCase
import ows.kotlinstudy.koinexample.ViewModel
import ows.kotlinstudy.koinexample.module


val mod1 = module {
    factory { ViewModel(get()) }
    factory { Repository() }
}

val mod2 = module {
    factory { UseCase(get()) }
}