package ows.kotlinstudy.calculatorwithmvp.main

import ows.kotlinstudy.mvcexample.model.db.ResultDatabase
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity
import java.util.*

class MainPresenter(
    private val view: MainContract.View<MainPresenter>,
    private val db: ResultDatabase?
) : MainContract.Presenter {
    val numStack = Stack<Int>()
    val operationStack = Stack<Char>()
    var curText = ""
    var curNum = ""

    override fun onResume() {
        db?.let { db ->
            view.showResultRecyclerView(db.resultDao().getResultList())
        }
    }

    override fun onStop() {}

    override fun clickNumButton(num: Int) {
        curNum += "${num}"
        curText += "${num} "
        view.appendCurTextView("${num} ")
    }

    override fun clickPlusButton() {
        numStack.add(curNum.toInt())
        curNum = ""

        if (operationStack.empty()) {
            curText += "+ "
            view.appendCurTextView("+ ")
            operationStack.add('+')
            return
        }

        while (operationStack.isNotEmpty()) {
            if (operationStack.peek() == 'x') {
                val num1 = numStack.pop()
                val num2 = numStack.pop()

                numStack.add(num1 * num2)
                operationStack.pop()
            } else if (operationStack.peek() == '/') {
                val num1 = numStack.pop()
                val num2 = numStack.pop()

                numStack.add(num2 / num1)
                operationStack.pop()
            } else {
                break
            }
        }
        curText += "+ "
        view.appendCurTextView("+ ")
        operationStack.add('+')
    }

    override fun clickMinusButton() {
        numStack.add(curNum.toInt())
        curNum = ""

        if (operationStack.empty()) {
            curText += "- "
            view.appendCurTextView("- ")
            operationStack.add('-')
            return
        }

        while (operationStack.isNotEmpty()) {
            if (operationStack.peek() == 'x') {
                val num1 = numStack.pop()
                val num2 = numStack.pop()

                numStack.add(num1 * num2)
                operationStack.pop()
            } else if (operationStack.peek() == '/') {
                val num1 = numStack.pop()
                val num2 = numStack.pop()

                numStack.add(num2 / num1)
                operationStack.pop()
            } else {
                break
            }
        }
        curText += "- "
        view.appendCurTextView("- ")
        operationStack.add('-')
    }

    override fun clickMultiplyButton() {
        numStack.add(curNum.toInt())
        curNum = ""

        curText += "x "
        view.appendCurTextView("x ")
        operationStack.add('x')
    }

    override fun clickDivideButton() {
        numStack.add(curNum.toInt())
        curNum = ""

        curText + "/ "
        view.appendCurTextView("/ ")
        operationStack.add('/')
    }

    override fun clickEqualButton() {
        numStack.add(curNum.toInt())
        curNum = ""
        curText += "= "
        view.appendCurTextView("= ")

        while (operationStack.isNotEmpty() && numStack.size > 1) {
            if (operationStack.peek() == 'x') {
                val num1 = numStack.pop()
                val num2 = numStack.pop()

                numStack.add(num1 * num2)
                operationStack.pop()
            } else if (operationStack.peek() == '/') {
                val num1 = numStack.pop()
                val num2 = numStack.pop()

                numStack.add(num2 / num1)
                operationStack.pop()
            } else if (operationStack.peek() == '+') {
                val num1 = numStack.pop()
                val num2 = numStack.pop()

                numStack.add(num1 + num2)
                operationStack.pop()
            } else {
                val num1 = numStack.pop()
                val num2 = numStack.pop()

                numStack.add(num1 - num2)
                operationStack.pop()
            }
        }
        view.showResultTextView("${numStack.peek()}")

        db?.let { db ->
            db.resultDao().insertResult(
                ResultEntity(

                    "${curText} ${numStack.peek()}"
                )
            )
        }

    }

    override fun clickClearButton() {
        curNum = ""
        curText = ""
        view.showCurTextView("")
        view.showResultTextView("")
        numStack.clear()
        operationStack.clear()
    }
}