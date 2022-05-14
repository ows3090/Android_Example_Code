package ows.kotlinstudy.calculatorwithmvp

import org.junit.*
import org.mockito.Mockito
import ows.kotlinstudy.calculatorwithmvp.main.MainActivity
import ows.kotlinstudy.calculatorwithmvp.main.MainContract
import ows.kotlinstudy.calculatorwithmvp.main.MainPresenter
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity

class MainPresenterTest {

    @Test
    fun test(){
        mainPresenter.clickNumButton(1)
        mainPresenter.clickPlusButton()
        mainPresenter.clickNumButton(2)
        mainPresenter.clickEqualButton()
        Assert.assertEquals(mainPresenter.numStack.peek(), 3)
    }

    companion object{
        private var view = object: MainContract.View<MainPresenter>{
            override val presenter: MainContract.Presenter
                get() = MainPresenter(this, null)

            override fun appendCurTextView(text: String) {

            }

            override fun showCurTextView(text: String) {

            }

            override fun showResultTextView(text: String) {

            }

            override fun showResultRecyclerView(resultEntityList: List<ResultEntity>) {

            }
        }
        private lateinit var mainPresenter: MainPresenter

        @JvmStatic
        @BeforeClass
        fun setUp(){
            mainPresenter = view.presenter as MainPresenter
        }
    }
}