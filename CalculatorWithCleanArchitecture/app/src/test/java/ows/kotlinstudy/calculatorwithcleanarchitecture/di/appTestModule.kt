package ows.kotlinstudy.calculatorwithcleanarchitecture.di

import org.koin.android.experimental.dsl.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ows.kotlinstudy.calculatorwithcleanarchitecture.data.model.Calculator
import ows.kotlinstudy.calculatorwithcleanarchitecture.data.repository.ResultRepositoryImpl
import ows.kotlinstudy.calculatorwithcleanarchitecture.domain.main.*
import ows.kotlinstudy.calculatorwithcleanarchitecture.domain.repository.ResultRepository
import ows.kotlinstudy.calculatorwithcleanarchitecture.presentation.main.MainViewModel
import ows.kotlinstudy.calculatorwithcleanarchitecture.repository.MockRepositoryImpl
import ows.kotlinstudy.mvcexample.model.db.ResultDatabase
import java.util.*

val appTestModule = module {
    // DB
    single { ResultDatabase.build(androidContext()) }
    single { get<ResultDatabase>().resultDao() }

    // Repository
    single<ResultRepository> { MockRepositoryImpl() }

    // Calculator
    single { Calculator(Stack<Int>(), Stack<Char>()) }

    // UseCase
    single { ClickClearUseCase(get()) }
    single { ClickDivideUseCase(get()) }
    single { ClickEqualUseCase(get(), get()) }
    single { ClickMinusUseCase(get()) }
    single { ClickMultiplyUseCase(get()) }
    single { ClickNumberUseCase(get()) }
    single { ClickPlusUseCase(get()) }
    single { GetResultHistoryUseCase(get()) }

    // ViewModel
    viewModel {
        MainViewModel(
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
}