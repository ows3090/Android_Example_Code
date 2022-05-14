package ows.kotlinstudy.calculatorwithmvp.base

import ows.kotlinstudy.mvcexample.model.NumModel

interface BasePresenter {
    fun onResume()
    fun onStop()
}