package ows.kotlinstudy.calculatorwithcleanarchitecture.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ows.kotlinstudy.calculatorwithcleanarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var mainResultAdapter: MainResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initView()
        bindView()
    }

    private fun initView(){
        if(!::mainResultAdapter.isInitialized){
            mainResultAdapter = MainResultAdapter()
        }

        binding.resultRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainResultAdapter
        }
    }

    private fun bindView() = with(binding){
        button0.setOnClickListener { presenter.clickNumButton(0) }
        button1.setOnClickListener { presenter.clickNumButton(1) }
        button2.setOnClickListener { presenter.clickNumButton(2) }
        button3.setOnClickListener { presenter.clickNumButton(3) }
        button4.setOnClickListener { presenter.clickNumButton(4) }
        button5.setOnClickListener { presenter.clickNumButton(5) }
        button6.setOnClickListener { presenter.clickNumButton(6) }
        button7.setOnClickListener { presenter.clickNumButton(7) }
        button8.setOnClickListener { presenter.clickNumButton(8) }
        button9.setOnClickListener { presenter.clickNumButton(9) }
        plusButton.setOnClickListener { presenter.clickPlusButton() }
        minusButton.setOnClickListener { presenter.clickMinusButton() }
        multiplyButton.setOnClickListener { presenter.clickMultiplyButton() }
        divideButton.setOnClickListener { presenter.clickDivideButton() }
        clearButton.setOnClickListener { presenter.clickClearButton() }
        equalButton.setOnClickListener { presenter.clickEqualButton() }
    }
}