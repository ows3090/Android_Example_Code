package ows.kotlinstudy.calculatorwithcleanarchitecture.domain.main

import ows.kotlinstudy.calculatorwithcleanarchitecture.data.model.Calculator
import ows.kotlinstudy.calculatorwithcleanarchitecture.domain.repository.ResultRepository
import ows.kotlinstudy.calculatorwithcleanarchitecture.domain.usecase.UseCase
import ows.kotlinstudy.mvcexample.model.db.dao.ResultDao
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity

class ClickEqualUseCase(
    private val calculator: Calculator,
    private val resultRepository: ResultRepository
) : UseCase {

    operator fun invoke(): Pair<String, String> {
        calculator.numStack.add(calculator.curNumber.toInt())
        calculator.curNumber = ""

        while (calculator.operationStack.isNotEmpty() && calculator.numStack.size > 1) {
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
            } else if (calculator.operationStack.peek() == '+') {
                val num1 = calculator.numStack.pop()
                val num2 = calculator.numStack.pop()

                calculator.numStack.add(num1 + num2)
                calculator.operationStack.pop()
            } else {
                val num1 = calculator.numStack.pop()
                val num2 = calculator.numStack.pop()

                calculator.numStack.add(num1 - num2)
                calculator.operationStack.pop()
            }
        }

        resultRepository.insertResult(
            ResultEntity(
                "${calculator.curText} ${calculator.numStack.peek()}"
            )
        )

        return calculator.curText to "${calculator.numStack.peek()}"
    }
}