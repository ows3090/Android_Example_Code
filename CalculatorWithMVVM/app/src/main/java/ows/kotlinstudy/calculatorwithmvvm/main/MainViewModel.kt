package ows.kotlinstudy.calculatorwithmvvm.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ows.kotlinstudy.mvcexample.model.db.ResultDatabase
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity
import java.util.*

class MainViewModel(
    private val db: ResultDatabase
) {
    private val numStack = Stack<Int>()
    private val operationStack = Stack<Char>()

    private var _resultText = MutableLiveData<String>().apply { value = "" }
    val resultText: LiveData<String>
        get() = _resultText

    private var _curText = MutableLiveData<String>().apply { value = "" }
    val curText: LiveData<String>
        get() = _curText

    private var curNum = ""

    private var _items = MutableLiveData<List<ResultEntity>>()
    val items: LiveData<List<ResultEntity>>
        get() = _items

    init {
        _items.value = db.resultDao().getResultList()
    }

    fun clickNumButton(num: Int) {
        curNum += "${num}"
        _curText.value += "${num} "
    }

    fun clickPlusButton() {
        numStack.add(curNum.toInt())
        curNum = ""

        if (operationStack.empty()) {
            _curText.value += "+ "
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
        _curText.value += "+ "
        operationStack.add('+')
    }

    fun clickMinusButton() {
        numStack.add(curNum.toInt())
        curNum = ""

        if (operationStack.empty()) {
            _curText.value += "- "
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
        _curText.value += "- "
        operationStack.add('-')
    }

    fun clickMultiplyButton() {
        numStack.add(curNum.toInt())
        curNum = ""

        _curText.value += "x "
        operationStack.add('x')
    }

    fun clickDivideButton() {
        numStack.add(curNum.toInt())
        curNum = ""

        _curText.value += "/ "
        operationStack.add('/')
    }

    fun clickEqualButton() {
        numStack.add(curNum.toInt())
        curNum = ""
        _curText.value += "= "

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
        _resultText.value = "${numStack.peek()}"

        db.resultDao().insertResult(
            ResultEntity(
                "${curText.value} ${numStack.peek()}"
            )
        )
    }

    fun clickClearButton() {
        curNum = ""
        _curText.value = ""
        _resultText.value = ""
        numStack.clear()
        operationStack.clear()
    }
}