package ows.kotlinstudy.calculatorwithcleanarchitecture

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import org.junit.Before
import org.junit.Rule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import ows.kotlinstudy.calculatorwithcleanarchitecture.di.appTestModule

abstract class ViewModelTest : KoinTest{

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var context: Application

    @Before
    fun setup(){
        startKoin {
            androidContext(context)
            modules(appTestModule)
        }
    }
}