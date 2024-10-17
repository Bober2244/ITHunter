package dev.bober.presentation.screens.search.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.bober.presentation.adapter.AdapterDelegate
import dev.bober.presentation.adapter.DelegateItem
import dev.bober.presentation.databinding.MoreButtonItemBinding
import dev.bober.presentation.entity.MoreButton

class MoreButtonDelegate : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = MoreButtonItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        binding.moreButton.setOnClickListener {
            //TODO("открытие другого экрана")
        }
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        item: DelegateItem,
        position: Int
    ) {
        (holder as ViewHolder).bind(item as MoreButton)
    }

    override fun isOfViewType(item: DelegateItem): Boolean {
        return item is MoreButton
    }

    inner class ViewHolder(private val binding: MoreButtonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MoreButton) {
            with(binding){
                this.moreButton.text = item.text
            }
        }
    }
}