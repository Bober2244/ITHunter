package dev.bober.presentation.search.recyclers

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.bober.presentation.adapter.AdapterDelegate
import dev.bober.presentation.adapter.DelegateItem
import dev.bober.presentation.databinding.VacancyCardBinding
import dev.bober.presentation.model.Vacancy

class VacanciesDelegate : AdapterDelegate {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ViewHolder(
            VacancyCardBinding.inflate(
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
        (holder as ViewHolder).bind(item as Vacancy)
    }

    override fun isOfViewType(item: DelegateItem): Boolean = item is Vacancy

    inner class ViewHolder(private val binding: VacancyCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(model: Vacancy) {
            with(binding) {
                viewers.text = "Сейчас просматривает ${model.lookingNumber} человек"
                //TODO: visibility поменять на state_checked/unchecked
                favoriteIcon.visibility = if (model.isFavorite) VISIBLE else GONE
                jobTitle.text = model.title
                salary.text = model.salary.full //TODO: выбор full/short
                city.text = model.address.town //TODO: выбор town/street/house
                company.text = model.company
                experience.text = model.experience.text //TODO: выбор text/previewText
                publishedDate.text = model.publishedDate //TODO: сделать парсинг даты
            }
        }
    }
}