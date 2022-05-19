package ows.kotlinstudy.calculatorwithcleanarchitecture

import org.junit.*
import ows.kotlinstudy.calculatorwithcleanarchitecture.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.inject

class MainViewModelTest: ViewModelTest() {

    private val mainViewModel: MainViewModel by inject()

    @Test
    fun testPlusOperation(){
        mainViewModel.clickNumButton(1)
        mainViewModel.clickPlusButton()
        mainViewModel.clickNumButton(2)
        mainViewModel.clickEqualButton()
        Assert.assertEquals(mainViewModel.resultText.value, "3")
    }

}