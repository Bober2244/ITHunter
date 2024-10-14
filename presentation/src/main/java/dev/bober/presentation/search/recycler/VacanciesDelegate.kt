package dev.bober.presentation.search.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.bober.presentation.adapter.AdapterDelegate
import dev.bober.presentation.adapter.DelegateItem
import dev.bober.presentation.databinding.VacancyCardBinding
import dev.bober.presentation.entity.Vacancy
import dev.bober.presentation.utils.checkField

class VacanciesDelegate : AdapterDelegate {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val item = VacancyCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        with(item.favoriteIcon) {
            setOnClickListener {
                isSelected = !isSelected
            }
        }
        return ViewHolder(binding = item)
    }

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