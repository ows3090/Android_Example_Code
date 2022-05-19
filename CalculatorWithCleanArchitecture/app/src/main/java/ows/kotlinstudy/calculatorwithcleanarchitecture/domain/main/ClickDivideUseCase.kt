package ows.kotlinstudy.calculatorwithcleanarchitecture.domain.main

import ows.kotlinstudy.calculatorwithcleanarchitecture.data.model.Calculator
import ows.kotlinstudy.calculatorwithcleanarchitecture.domain.usecase.UseCase

class ClickDivideUseCase(
    private val calculator: Calculator
) : UseCase {

    operator fun invoke(): String {
        calculator.numStack.add(calculator.curNumber.toInt())
        calculator.curNumber = ""
        calculator.operationStack.add('/')
        calculator.curText += "/ "
        return "/ "
    }
}