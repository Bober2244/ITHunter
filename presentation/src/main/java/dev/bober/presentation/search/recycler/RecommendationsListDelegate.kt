package dev.bober.presentation.search.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.bober.presentation.adapter.AdapterDelegate
import dev.bober.presentation.adapter.DelegateItem
import dev.bober.presentation.databinding.RecommendationsListBinding
import dev.bober.presentation.entity.Offers

class RecommendationsListDelegate : AdapterDelegate {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ViewHolder(
            RecommendationsListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        item: DelegateItem,
        position: Int
    ) {
        (holder as ViewHolder).bind(item as Offers)
    }

    override fun isOfViewType(item: DelegateItem): Boolean = item is Offers

    inner class ViewHolder(private val binding: RecommendationsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Offers) {
            val adapter = OffersAdapter()
            with(binding) {
                recommendationsList.adapter = adapter
               adapter.submitList(model.id)
            }
        }
    }
}