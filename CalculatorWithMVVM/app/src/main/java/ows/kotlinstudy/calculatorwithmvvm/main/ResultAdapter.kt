package ows.kotlinstudy.calculatorwithmvvm.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ows.kotlinstudy.calculatorwithmvvm.databinding.ItemResultBinding
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity

class ResultAdapter : ListAdapter<ResultEntity, ResultAdapter.ResultViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(
            ItemResultBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.bind(currentList.get(position))
    }

    inner class ResultViewHolder(
        private val binding: ItemResultBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(resultEntity: ResultEntity) {
            binding.resultTextView.text = resultEntity.result
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ResultEntity>() {
            override fun areItemsTheSame(oldItem: ResultEntity, newItem: ResultEntity): Boolean {
                return oldItem.result == newItem.result
            }

            override fun areContentsTheSame(oldItem: ResultEntity, newItem: ResultEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}