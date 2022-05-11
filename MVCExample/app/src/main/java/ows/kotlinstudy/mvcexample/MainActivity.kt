package ows.kotlinstudy.mvcexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import ows.kotlinstudy.mvcexample.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val numStack = Stack<Int>()
    private val operationStack = Stack<Char>()
    private var curNum = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindViews()
    }

    private fun bindViews() = with(binding) {
        button0.setOnClickListener { clickNumButton(NumModel(0)) }
        button1.setOnClickListener { clickNumButton(NumModel(1)) }
        button2.setOnClickListener { clickNumButton(NumModel(2)) }
        button3.setOnClickListener { clickNumButton(NumModel(3)) }
        button4.setOnClickListener { clickNumButton(NumModel(4)) }
        button5.setOnClickListener { clickNumButton(NumModel(5)) }
        button6.setOnClickListener { clickNumButton(NumModel(6)) }
        button7.setOnClickListener { clickNumButton(NumModel(7)) }
        button8.setOnClickListener { clickNumButton(NumModel(8)) }
        button9.setOnClickListener { clickNumButton(NumModel(9)) }
        plusButton.setOnClickListener { clickPlusButton() }
        minusButton.setOnClickListener { clickMinusButton() }
        multiplyButton.setOnClickListener { clickMultiplyButton() }
        divideButton.setOnClickListener { clickDivideButton() }
        clearButton.setOnClickListener { clickClearButton() }
        equalButton.setOnClickListener { clickEqualButton() }
    }

    private fun clickNumButton(numModel: NumModel) {
        curNum += "${numModel.num}"
        binding.curTextView.append("${numModel.num} ")
    }

    private fun clickPlusButton() {
        numStack.add(curNum.toInt())
        curNum = ""

        if (operationStack.empty()) {
            binding.curTextView.append("+ ")
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

                numStack.add(num1 / num2)
                operationStack.pop()
            } else {
                break
            }
        }
        binding.curTextView.append("+ ")
        operationStack.add('+')
    }

    private fun clickMinusButton() {
        numStack.add(curNum.toInt())
        curNum = ""

        if (operationStack.empty()) {
            binding.curTextView.append("- ")
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

                numStack.add(num1 / num2)
                operationStack.pop()
            } else {
                break
            }
        }
        binding.curTextView.append("- ")
        operationStack.add('-')
    }

    private fun clickMultiplyButton() {
        numStack.add(curNum.toInt())
        curNum = ""

        binding.curTextView.append("x ")
        operationStack.add('x')
    }

    private fun clickDivideButton() {
        numStack.add(curNum.toInt())
        curNum = ""

        binding.curTextView.append("/ ")
        operationStack.add('/')
    }

    private fun clickClearButton() {
        curNum = ""
        binding.curTextView.text = ""
        binding.resultTextView.text = ""
        numStack.clear()
        operationStack.clear()
    }

    private fun clickEqualButton() {
        numStack.add(curNum.toInt())
        curNum = ""
        binding.curTextView.append("= ")

        while (operationStack.isNotEmpty() && numStack.size > 1) {
            if (operationStack.peek() == 'x') {
                val num1 = numStack.pop()
                val num2 = numStack.pop()

                numStack.add(num1 * num2)
                operationStack.pop()
            } else if (operationStack.peek() == '/') {
                val num1 = numStack.pop()
                val num2 = numStack.pop()

                numStack.add(num1 / num2)
                operationStack.pop()
            } else if (operationStack.peek() == '+') {
                val num1 = numStack.pop()
                val num2 = numStack.pop()

                numStack.add(num1 + num2)
                operationStack.pop()
            }else{
                val num1 = numStack.pop()
                val num2 = numStack.pop()

                numStack.add(num1 - num2)
                operationStack.pop()
            }
        }
        binding.resultTextView.text = "${numStack.peek()}"
    }

    companion object {
        const val TAG = "MainActivity"
    }
}