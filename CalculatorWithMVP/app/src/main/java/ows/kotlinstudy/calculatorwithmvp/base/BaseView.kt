package ows.kotlinstudy.calculatorwithmvp.base

interface BaseView<PresenterT: BasePresenter> {
    val presenter: PresenterT
}