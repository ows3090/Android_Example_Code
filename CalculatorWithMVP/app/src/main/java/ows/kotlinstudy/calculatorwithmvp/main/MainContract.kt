package ows.kotlinstudy.calculatorwithmvp.main

import ows.kotlinstudy.calculatorwithmvp.base.BasePresenter
import ows.kotlinstudy.calculatorwithmvp.base.BaseView
import ows.kotlinstudy.mvcexample.model.NumModel
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity

interface MainContract {

    interface View: BaseView<Presenter>{
        fun appendCurTextView(text: String)
        fun showCurTextView(text: String)
        fun showResultTextView(text: String)
        fun showResultRecyclerView(resultEntityList: List<ResultEntity>)
    }

    interface Presenter: BasePresenter{
        fun clickNumButton(num: Int)
        fun clickPlusButton()
        fun clickMinusButton()
        fun clickMultiplyButton()
        fun clickDivideButton()
        fun clickEqualButton()
        fun clickClearButton()
    }
}