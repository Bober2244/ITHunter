package dev.bober.presentation.utils

import dev.bober.domain.model.ResultModel
import dev.bober.domain.model.VacancyModel
import dev.bober.presentation.adapter.DelegateItem
import dev.bober.presentation.entity.Offer
import dev.bober.presentation.entity.Offers
import dev.bober.presentation.entity.Vacancy

fun MutableList<DelegateItem>.concatenate(data: ResultModel) {
    val offersList = Offers(id = mutableListOf())

    data.offers.forEach { model ->
        offersList.id.add(
            Offer(
                id = model.id ?: "",
                title = model.title,
                button = model.button ?: "",
                link = model.link
            )
        )
    }
    this.add(offersList)

    data.vacancies.subList(0, 3).forEach { model ->
        this.add(
            Vacancy(
                id = model.id,
                lookingNumber = model.lookingNumber,
                title = model.title,
                address = model.address,
                company = model.company,
                experience = model.experience,
                publishedDate = model.publishedDate,
                isFavorite = model.isFavorite,
                salary = model.salary,
                schedules = model.schedules,
                appliedNumber = model.appliedNumber ?: 0,
                description = model.description ?: "",
                responsibilities = model.responsibilities,
                questions = model.questions,
            )
        )
    }
}

fun List<VacancyModel>.toFavoritesList(): List<Vacancy> {
    val vacancies = mutableListOf<Vacancy>()
    this.asSequence()
        .forEach { model ->
        if (model.isFavorite){
            vacancies.add(
                Vacancy(
                    id = model.id,
                    lookingNumber = model.lookingNumber,
                    title = model.title,
                    address = model.address,
                    company = model.company,
                    experience = model.experience,
                    publishedDate = model.publishedDate,
                    isFavorite = model.isFavorite,
                    salary = model.salary,
                    schedules = model.schedules,
                    appliedNumber = model.appliedNumber ?: 0,
                    description = model.description ?: "",
                    responsibilities = model.responsibilities,
                    questions = model.questions,
                )
            )
        }
    }
    return vacancies
}