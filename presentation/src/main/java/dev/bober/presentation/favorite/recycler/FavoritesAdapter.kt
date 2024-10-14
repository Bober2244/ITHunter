package dev.bober.presentation.favorite.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.bober.presentation.databinding.VacancyCardBinding
import dev.bober.presentation.entity.Vacancy
import dev.bober.presentation.utils.checkField

class FavoritesAdapter : ListAdapter<Vacancy, FavoritesAdapter.ViewHolder>(DiffItemUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            VacancyCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    private class DiffItemUtil : ItemCallback<Vacancy>() {
        override fun areItemsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean {
            return oldItem::class == newItem::class && oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }

    inner class ViewHolder(private val binding: VacancyCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Vacancy) {
            with(binding) {
                viewers.checkField(item.lookingNumber) {
                    if ((item.lookingNumber?.rem(10)) in 2..4) {
                        viewers.text = "Сейчас просматривает ${item.lookingNumber} человека"
                    } else viewers.text = "Сейчас просматривает ${item.lookingNumber} человек"
                }
                favoriteIcon.isSelected = item.isFavorite
                jobTitle.text = item.title
                salary.text = item.salary.short ?: item.salary.full
                city.text = item.address.town
                company.text = item.company
                experience.text = item.experience.previewText
                publishedDate.text = item.publishedDate //TODO: сделать парсинг даты
            }
        }
    }
}