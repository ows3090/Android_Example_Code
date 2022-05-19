package ows.kotlinstudy.calculatorwithcleanarchitecture.domain.main

import ows.kotlinstudy.calculatorwithcleanarchitecture.data.model.Calculator
import ows.kotlinstudy.calculatorwithcleanarchitecture.domain.usecase.UseCase

class ClickPlusUseCase(
    private val calculator: Calculator
) : UseCase {

    operator fun invoke(): String {
        calculator.numStack.add(calculator.curNumber.toInt())
        calculator.curNumber = ""

        if (calculator.operationStack.empty()) {
            calculator.operationStack.add('+')
            calculator.curText += "+ "
            return calculator.curText
        }

        while (calculator.operationStack.isNotEmpty()) {
            if (calculator.operationStack.peek() == 'x') {
                val num1 = calculator.numStack.pop()
                val num2 = calculator.numStack.pop()

                calculator.numStack.add(num1 * num2)
                calculator.operationStack.pop()
            } else if (calculator.operationStack.peek() == '/') {
                val num1 = calculator.numStack.pop()
                val num2 = calculator.numStack.pop()

                calculator.numStack.add(num2 / num1)
                calculator.operationStack.pop()
            } else {
                break
            }
        }

        calculator.operationStack.add('+')
        calculator.curText += "+ "
        return calculator.curText
    }
}