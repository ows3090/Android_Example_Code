package ows.kotlinstudy.calculatorwithcleanarchitecture.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        setContentView(binding.root)

        initView()
        bindView()

        initViewModel()
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
        button0.setOnClickListener { mainViewModel.clickNumButton(0) }
        button1.setOnClickListener { mainViewModel.clickNumButton(1) }
        button2.setOnClickListener { mainViewModel.clickNumButton(2) }
        button3.setOnClickListener { mainViewModel.clickNumButton(3) }
        button4.setOnClickListener { mainViewModel.clickNumButton(4) }
        button5.setOnClickListener { mainViewModel.clickNumButton(5) }
        button6.setOnClickListener { mainViewModel.clickNumButton(6) }
        button7.setOnClickListener { mainViewModel.clickNumButton(7) }
        button8.setOnClickListener { mainViewModel.clickNumButton(8) }
        button9.setOnClickListener { mainViewModel.clickNumButton(9) }
        plusButton.setOnClickListener { mainViewModel.clickPlusButton() }
        minusButton.setOnClickListener { mainViewModel.clickMinusButton() }
        multiplyButton.setOnClickListener { mainViewModel.clickMultiplyButton() }
        divideButton.setOnClickListener { mainViewModel.clickDivideButton() }
        clearButton.setOnClickListener { mainViewModel.clickClearButton() }
        equalButton.setOnClickListener { mainViewModel.clickEqualButton() }
    }

    private fun initViewModel(){
        mainViewModel.curText.observe(this){
            binding.curTextView.text = it
        }

        mainViewModel.resultText.observe(this){
            binding.resultTextView.text = it
        }

        mainViewModel.resultHistoryList.observe(this){
            mainResultAdapter.submitList(it)
        }
    }
}