package ows.kotlinstudy.calculatorwithmvp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule
import ows.kotlinstudy.calculatorwithmvp.main.MainActivity
import ows.kotlinstudy.calculatorwithmvp.main.MainContract
import ows.kotlinstudy.calculatorwithmvp.main.MainPresenter

class MainPresenterTest {

    @Test
    fun test(){
        presenter.clickNumButton(1)
        Assert.assertEquals(presenter.curNum, "1")
    }

    companion object{
        private lateinit var view: MainContract.View
        private lateinit var presenter: MainPresenter

        @JvmStatic
        @BeforeClass
        fun setUp(){
            view = Mockito.mock(MainActivity::class.java)
            presenter = MainPresenter(view, null)
        }
    }
}