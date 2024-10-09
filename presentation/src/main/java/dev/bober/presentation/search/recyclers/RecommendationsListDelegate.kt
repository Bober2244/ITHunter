package dev.bober.presentation.search.recyclers

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.bober.presentation.R
import dev.bober.presentation.adapter.AdapterDelegate
import dev.bober.presentation.adapter.DelegateItem
import dev.bober.presentation.databinding.RecommendationBinding
import dev.bober.presentation.databinding.RecommendationsListBinding
import dev.bober.presentation.entity.Offer

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
        (holder as ViewHolder).bind(item as Offer)
    }

    override fun isOfViewType(item: DelegateItem): Boolean = item is Offer

    inner class ViewHolder(private val binding: RecommendationsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Offer) {
            with(binding) {
                recommendationsList.adapter = OffersAdapter()
            }
        }
    }
}