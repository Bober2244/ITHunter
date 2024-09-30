package dev.bober.presentation.adapter.utils

import dev.bober.presentation.adapter.DelegateItem
import dev.bober.presentation.model.Offer
import dev.bober.presentation.model.Vacancy

fun List<Vacancy>.concatenateWithOffers(offers: List<Offer>): List<DelegateItem> {
    val delegateItemList: MutableList<DelegateItem> = mutableListOf()

    offers.forEach { model ->
        delegateItemList.add(
            Offer(
                id = model.id,
                title = model.title,
                button = model.button,
                link = model.link
            )
        )
    }
    this.forEach { model ->
        delegateItemList.add(
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
                appliedNumber = model.appliedNumber,
                description = model.description,
                responsibilities = model.responsibilities,
                questions = model.questions,
            )
        )
    }
    return delegateItemList
}

fun List<Offer>.concatenateWithVacancy(vacancies : List<Vacancy>): List<DelegateItem> {
    val delegateItemList: MutableList<DelegateItem> = mutableListOf()

    vacancies.forEach { model ->
        delegateItemList.add(
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
                appliedNumber = model.appliedNumber,
                description = model.description,
                responsibilities = model.responsibilities,
                questions = model.questions,
            )
        )
    }
    this.forEach { model ->
        delegateItemList.add(
            Offer(
                id = model.id,
                title = model.title,
                button = model.button,
                link = model.link
            )
        )
    }
    return delegateItemList
}