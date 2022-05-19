package ows.kotlinstudy.calculatorwithcleanarchitecture.domain.main

import ows.kotlinstudy.calculatorwithcleanarchitecture.data.model.Calculator
import ows.kotlinstudy.calculatorwithcleanarchitecture.domain.usecase.UseCase

class ClickClearUseCase(
    private val calculator: Calculator
) : UseCase {

    operator fun invoke() {
        calculator.curNumber = ""
        calculator.curText = ""
        calculator.resultText = ""
        calculator.numStack.clear()
        calculator.operationStack.clear()
    }
}