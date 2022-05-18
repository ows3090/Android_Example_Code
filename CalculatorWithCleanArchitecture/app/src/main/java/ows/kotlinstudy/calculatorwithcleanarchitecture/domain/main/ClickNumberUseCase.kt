package ows.kotlinstudy.calculatorwithcleanarchitecture.domain.main

import ows.kotlinstudy.calculatorwithcleanarchitecture.data.model.Calculator
import ows.kotlinstudy.calculatorwithcleanarchitecture.domain.UseCase

class ClickNumberUseCase(
    private val calculator: Calculator
) : UseCase {

    operator fun invoke(num: Int) : String{
        calculator.curNumber += "${num}"
        calculator.curText += "${num} "
        return calculator.curText
    }
}