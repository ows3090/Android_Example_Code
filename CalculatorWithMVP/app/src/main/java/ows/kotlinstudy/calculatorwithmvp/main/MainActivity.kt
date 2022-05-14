package ows.kotlinstudy.calculatorwithmvp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ows.kotlinstudy.calculatorwithmvp.databinding.ActivityMainBinding
import ows.kotlinstudy.mvcexample.model.db.ResultDatabase
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity

class MainActivity : AppCompatActivity(), MainContract.View<MainPresenter> {

    private lateinit var binding: ActivityMainBinding

    override val presenter: MainContract.Presenter by lazy {
        MainPresenter(
            this,
            ResultDatabase.build(applicationContext)
        )
    }
    private val resultAdapter by lazy { ResultAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        bindViews()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()

    }

    private fun initViews() = with(binding) {
        resultRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = resultAdapter
        }
    }

    private fun bindViews() = with(binding) {
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

    override fun appendCurTextView(text: String) {
        binding.curTextView.append(text)
    }

    override fun showCurTextView(text: String) {
        binding.curTextView.text = text
    }

    override fun showResultTextView(text: String) {
        binding.resultTextView.text = text
    }

    override fun showResultRecyclerView(resultEntityList: List<ResultEntity>) {
        resultAdapter.submitList(resultEntityList)
    }
}