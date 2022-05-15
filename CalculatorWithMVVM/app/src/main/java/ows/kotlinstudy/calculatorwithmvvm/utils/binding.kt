package ows.kotlinstudy.calculatorwithmvvm.utils

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import ows.kotlinstudy.calculatorwithmvvm.main.ResultAdapter
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity


@BindingAdapter("android:resultItems")
fun setItems(recyclerView: RecyclerView, listItem: LiveData<List<ResultEntity>>){
    Log.d("binding","${listItem.value}")
    (recyclerView.adapter as ResultAdapter).submitList(listItem.value)
}