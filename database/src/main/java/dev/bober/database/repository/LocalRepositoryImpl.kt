package dev.bober.database.repository

import dev.bober.database.dao.OfferDao
import dev.bober.database.dao.VacancyDao
import dev.bober.database.entity.AddressEntity
import dev.bober.database.entity.ExperienceEntity
import dev.bober.database.entity.OfferEntity
import dev.bober.database.entity.SalaryEntity
import dev.bober.database.entity.VacancyEntity
import dev.bober.domain.model.OfferModel
import dev.bober.domain.model.VacancyModel
import dev.bober.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalRepositoryImpl(
    private val vacancyDao: VacancyDao,
    private val offerDao: OfferDao
) : LocalRepository {

    override suspend fun getVacancies(): Flow<List<VacancyEntity>> {
        return vacancyDao.getVacancies()
    }

    override suspend fun insertVacancies(vacancies: List<VacancyModel>) {
        vacancyDao.insertVacancies(
            vacancies.map { vacancy ->
                VacancyEntity(
                    id = vacancy.id,
                    lookingNumber = vacancy.lookingNumber,
                    title = vacancy.title,
                    address = AddressEntity(vacancy.address.town, vacancy.address.street, vacancy.address.house),
                    company = vacancy.company,
                    experience = ExperienceEntity(vacancy.experience.previewText, vacancy.experience.text),
                    publishedDate = vacancy.publishedDate,
                    isFavorite = vacancy.isFavorite,
                    salary = SalaryEntity(vacancy.salary.short, vacancy.salary.full),
                    schedules = vacancy.schedules,
                    appliedNumber = vacancy.appliedNumber,
                    description = vacancy.description,
                    questions = vacancy.questions,
                    responsibilities = vacancy.responsibilities
                )
            }
        )
    }

    override suspend fun addFavorite(vacancy: VacancyModel) {
        vacancyDao.insertVacancy(
            VacancyEntity(
                id = vacancy.id,
                lookingNumber = vacancy.lookingNumber,
                title = vacancy.title,
                address = AddressEntity(vacancy.address.town, vacancy.address.street, vacancy.address.house),
                company = vacancy.company,
                experience = ExperienceEntity(vacancy.experience.previewText, vacancy.experience.text),
                publishedDate = vacancy.publishedDate,
                isFavorite = vacancy.isFavorite,
                salary = SalaryEntity(vacancy.salary.short, vacancy.salary.full),
                schedules = vacancy.schedules,
                appliedNumber = vacancy.appliedNumber,
                description = vacancy.description,
                questions = vacancy.questions,
                responsibilities = vacancy.responsibilities
            )
        )
    }

    override suspend fun removeFavorite(id: String) {
        vacancyDao.removeFavorite(id)
    }

    override suspend fun getFavorites(): Flow<List<Any>> {
        return vacancyDao.getFavorites()
    }

    override suspend fun getFavoritesCount(): Flow<Int> {
        return vacancyDao.getFavoriteCount()
    }

    override suspend fun insertOffers(offers: List<OfferModel>) {
        offerDao.insertOffers(
            offers = offers.map {
                OfferEntity(
                    id = it.id,
                    title = it.title,
                    button = it.button,
                    link = it.link
                )
            }
        )
    }

    override suspend fun getOffers(): Flow<List<OfferModel>> {
        return offerDao.getOffers().map { offersList ->
            offersList.map {
                OfferModel(
                    id = it.id,
                    title = it.title,
                    button = it.button,
                    link = it.link
                )
            }
        }
    }
}