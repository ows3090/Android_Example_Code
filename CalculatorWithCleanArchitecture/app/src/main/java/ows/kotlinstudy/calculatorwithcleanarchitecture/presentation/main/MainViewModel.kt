package ows.kotlinstudy.calculatorwithcleanarchitecture.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ows.kotlinstudy.calculatorwithcleanarchitecture.domain.main.*
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity

class MainViewModel(
    private val clickNumberUseCase: ClickNumberUseCase,
    private val clickPlusUseCase: ClickPlusUseCase,
    private val clickMinusUseCase: ClickMinusUseCase,
    private val clickMultiplyUseCase: ClickMultiplyUseCase,
    private val clickDivideUseCase: ClickDivideUseCase,
    private val clickEqualUseCase: ClickEqualUseCase,
    private val clickClearUseCase: ClickClearUseCase,
    getResultHistoryUseCase: GetResultHistoryUseCase
) : ViewModel() {

    private var _curText = MutableLiveData<String>()
    val curText: LiveData<String>
        get() = _curText

    private var _resultText = MutableLiveData<String>()
    val resultText: LiveData<String>
        get() = _resultText

    private var _resultHistoryList = MutableLiveData<List<ResultEntity>>()
    val resultHistoryList: LiveData<List<ResultEntity>>
        get() = _resultHistoryList

    init {
        _resultHistoryList.value = getResultHistoryUseCase()
    }

    fun clickNumButton(num: Int) {
        _curText.value = clickNumberUseCase(num)
    }

    fun clickPlusButton() {
        _curText.value = clickPlusUseCase()
    }

    fun clickMinusButton() {
        _curText.value = clickMinusUseCase()
    }

    fun clickMultiplyButton() {
        _curText.value = clickMultiplyUseCase()
    }

    fun clickDivideButton() {
        _curText.value = clickDivideUseCase()
    }

    fun clickClearButton() {
        clickClearUseCase()
        _curText.value = ""
        _resultText.value = ""
    }

    fun clickEqualButton() {
        val result = clickEqualUseCase()
        _curText.value = result.first!!
        _resultText.value = result.second!!
    }
}