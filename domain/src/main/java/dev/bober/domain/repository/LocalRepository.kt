package dev.bober.domain.repository

import dev.bober.domain.model.OfferModel
import dev.bober.domain.model.VacancyModel
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun insertVacancies(vacancies: List<VacancyModel>)
    suspend fun getVacancies(): Flow<List<Any>> //TODO("Поменять на VacancyModel")
    suspend fun addFavorite(vacancy: VacancyModel)
    suspend fun removeFavorite(id: String)
    suspend fun getFavorites(): Flow<List<Any>> //TODO("Поменять на VacancyModel")
    suspend fun getFavoritesCount(): Flow<Int>
    suspend fun insertOffers(offers: List<OfferModel>)
    suspend fun getOffers(): Flow<List<OfferModel>>
}