package dev.bober.presentation.search.recyclers

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.bober.presentation.R
import dev.bober.presentation.adapter.AdapterDelegate
import dev.bober.presentation.adapter.DelegateItem
import dev.bober.presentation.databinding.RecommendationsBinding
import dev.bober.presentation.model.Offer

class RecommendationsDelegate : AdapterDelegate {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ViewHolder(
            RecommendationsBinding.inflate(
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

    inner class ViewHolder(private val binding: RecommendationsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: Offer) {
            val imageRes = when (model.id) {
                "near_vacancies" -> R.drawable.ic_near_vacancies
                "level_up_resume" -> R.drawable.ic_level_up_resume
                "temporary_job" -> R.drawable.ic_temporary_job
                else -> {0}
            }

            with(binding) {
                topIcon.setImageResource(imageRes)
                recomTitle.text = model.title
                linkButton.visibility = if (model.button.text.isEmpty()) GONE else VISIBLE
                linkButton.text = model.button.text
            }
        }
    }
}