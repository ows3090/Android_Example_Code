package ows.kotlinstudy.calculatorwithmvvm

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import ows.kotlinstudy.calculatorwithmvvm.main.MainViewModel
import ows.kotlinstudy.mvcexample.model.db.ResultDatabase

class MainViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var mainViewModel: MainViewModel

    @Before
    fun setUp() {
        mainViewModel = MainViewModel (null)
    }

    @Test
    fun test() {
        mainViewModel.clickNumButton(1)
        mainViewModel.clickPlusButton()
        mainViewModel.clickNumButton(3)
        mainViewModel.clickEqualButton()
        Assert.assertEquals(mainViewModel.resultText.value, "4")
    }
}