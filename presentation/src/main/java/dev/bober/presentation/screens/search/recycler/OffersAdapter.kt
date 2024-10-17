package dev.bober.presentation.screens.search.recycler

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.bober.presentation.R
import dev.bober.presentation.databinding.RecommendationBinding
import dev.bober.presentation.entity.Offer

class OffersAdapter(
    val onClick: (link: String) -> Unit
) : ListAdapter<Offer, OffersAdapter.ViewHolder>(DiffItemUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecommendationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    private class DiffItemUtil : ItemCallback<Offer>() {
        override fun areItemsTheSame(oldItem: Offer, newItem: Offer): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Offer, newItem: Offer): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }

    inner class ViewHolder(private val binding: RecommendationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Offer) {
            val imageRes = when (item.id) {
                ids[0] -> R.drawable.ic_near_vacancies
                ids[1] -> R.drawable.ic_level_up_resume
                ids[2] -> R.drawable.ic_temporary_job
                else -> {
                    0
                }
            }
            with(binding) {
                topIcon.setImageResource(imageRes)
                recomTitle.text = item.title
                linkButton.visibility = if (item.button.isNullOrEmpty()) GONE else VISIBLE
                linkButton.text = item.button
                root.visibility = if (item.id.isNullOrEmpty()) GONE else VISIBLE
                root.setOnClickListener {
                    onClick(item.link)
                }
            }
        }

        private val ids: List<String> = listOf("near_vacancies", "level_up_resume", "temporary_job")
    }
}