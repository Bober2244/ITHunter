package dev.bober.database.util

import dev.bober.database.entity.AddressEntity
import dev.bober.database.entity.ExperienceEntity
import dev.bober.database.entity.OfferEntity
import dev.bober.database.entity.SalaryEntity
import dev.bober.database.entity.VacancyEntity
import dev.bober.domain.model.AddressModel
import dev.bober.domain.model.ExperienceModel
import dev.bober.domain.model.OfferModel
import dev.bober.domain.model.SalaryModel
import dev.bober.domain.model.VacancyModel

object DomainMapper {

    fun VacancyEntity.toDomainModel() : VacancyModel {
        return VacancyModel(
            id = id,
            lookingNumber = lookingNumber,
            title = title,
            address = AddressModel(address.town, address.street, address.house),
            company = company,
            experience = ExperienceModel(experience.previewText, experience.text),
            publishedDate = publishedDate,
            isFavorite = isFavorite,
            salary = SalaryModel(salary.short, salary.full),
            schedules = schedules,
            appliedNumber = appliedNumber,
            description = description,
            questions = questions,
            responsibilities = responsibilities
        )
    }

    fun VacancyModel.toEntity() : VacancyEntity {
        return VacancyEntity(
            id = id,
            lookingNumber = lookingNumber,
            title = title,
            address = AddressEntity(address.town, address.street, address.house),
            company = company,
            experience = ExperienceEntity(experience.previewText, experience.text),
            publishedDate = publishedDate,
            isFavorite = isFavorite,
            salary = SalaryEntity(salary.short, salary.full),
            schedules = schedules,
            appliedNumber = appliedNumber,
            description = description,
            questions = questions,
            responsibilities = responsibilities
        )
    }

    fun OfferModel.toEntity() : OfferEntity {
        return OfferEntity(
            id = id,
            title = title,
            button = button,
            link = link
        )
    }

    fun OfferEntity.toDomainModel() : OfferModel {
        return OfferModel(
            id = id,
            title = title,
            button = button,
            link = link
        )
    }
}