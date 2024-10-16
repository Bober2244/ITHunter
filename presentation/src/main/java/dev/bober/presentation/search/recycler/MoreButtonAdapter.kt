package dev.bober.presentation.search.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.bober.presentation.adapter.AdapterDelegate
import dev.bober.presentation.adapter.DelegateItem
import dev.bober.presentation.databinding.MoreButtonItemBinding
import dev.bober.presentation.entity.MoreButton

class MoreButtonAdapter : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(
            MoreButtonItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
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