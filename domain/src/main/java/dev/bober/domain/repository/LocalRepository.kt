package dev.bober.domain.repository

import dev.bober.domain.model.OfferModel
import dev.bober.domain.model.VacancyModel
import dev.bober.utils.Resource
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun insertVacancies(vacancies: List<VacancyModel>)
    suspend fun getVacancies(): Flow<Resource<List<VacancyModel>>>
    suspend fun addFavorite(vacancy: VacancyModel)
    suspend fun removeFavorite(id: String)
    suspend fun getFavorites(): Flow<Resource<List<VacancyModel>>>
    suspend fun getFavoritesCount(): Flow<Resource<Int>>
    suspend fun insertOffers(offers: List<OfferModel>)
    suspend fun getOffers(): Flow<Resource<List<OfferModel>>>
}