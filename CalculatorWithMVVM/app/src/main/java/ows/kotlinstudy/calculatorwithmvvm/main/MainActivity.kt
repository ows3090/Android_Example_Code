package ows.kotlinstudy.calculatorwithmvvm.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import ows.kotlinstudy.calculatorwithmvvm.R
import ows.kotlinstudy.calculatorwithmvvm.databinding.ActivityMainBinding
import ows.kotlinstudy.mvcexample.model.db.ResultDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewmodel = MainViewModel(ResultDatabase.build(applicationContext))
        bindViews()
    }

    private fun bindViews(){
        binding.resultRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ResultAdapter()
        }
    }
}