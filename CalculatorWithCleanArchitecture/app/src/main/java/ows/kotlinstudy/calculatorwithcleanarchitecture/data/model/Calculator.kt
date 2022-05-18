package ows.kotlinstudy.calculatorwithcleanarchitecture.data.model

import java.util.*

data class Calculator(
    val numStack: Stack<Int>,
    val operationStack: Stack<Char>,
    var curNumber: String = "",
    var curText: String = "",
    var resultText: String = ""
)