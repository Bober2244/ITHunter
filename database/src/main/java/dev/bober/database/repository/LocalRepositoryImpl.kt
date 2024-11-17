package dev.bober.database.repository

import dev.bober.database.dao.OfferDao
import dev.bober.database.dao.VacancyDao
import dev.bober.database.entity.AddressEntity
import dev.bober.database.entity.ExperienceEntity
import dev.bober.database.entity.OfferEntity
import dev.bober.database.entity.SalaryEntity
import dev.bober.database.entity.VacancyEntity
import dev.bober.database.util.DomainMapper.toDomainModel
import dev.bober.database.util.DomainMapper.toEntity
import dev.bober.domain.model.OfferModel
import dev.bober.domain.model.VacancyModel
import dev.bober.domain.repository.LocalRepository
import dev.bober.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform

class LocalRepositoryImpl(
    private val vacancyDao: VacancyDao,
    private val offerDao: OfferDao
) : LocalRepository {

    override suspend fun getVacancies(): Flow<Resource<List<VacancyModel>>> = flow {
        emit(Resource.Loading())
        try {
            emit(
                Resource.Success(
                    vacancyDao.getVacancies().map {
                        it.toDomainModel()
                    }
                )
            )

        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }

    override suspend fun insertVacancies(vacancies: List<VacancyModel>) {
        vacancyDao.insertVacancies(
            vacancies.map { vacancy ->
                vacancy.toEntity()
            }
        )
    }

    override suspend fun addFavorite(vacancy: VacancyModel) {
        vacancyDao.insertVacancy(
            vacancy.toEntity()
        )
    }

    override suspend fun removeFavorite(id: String) {
        vacancyDao.removeFavorite(id)
    }

    override suspend fun getFavorites(): Flow<Resource<List<VacancyModel>>> = flow {
        emit(Resource.Loading())
        try {
            emit(
                Resource.Success(
                    vacancyDao.getFavorites().map {
                        it.toDomainModel()
                    }
                )
            )
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }

    override suspend fun getFavoritesCount(): Flow<Resource<Int>> = flow {
        emit(Resource.Loading())
        try {
            emit(
                Resource.Success(
                    vacancyDao.getFavoriteCount()
                )
            )
        }
        catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }

    override suspend fun insertOffers(offers: List<OfferModel>) {
        offerDao.insertOffers(
            offers = offers.map {
                it.toEntity()
            }
        )
    }

    override suspend fun getOffers(): Flow<Resource<List<OfferModel>>> = flow {
        emit(Resource.Loading())
        try {
            emit(
                Resource.Success(
                    offerDao.getOffers().map {
                        it.toDomainModel()
                    }
                )
            )
        }
        catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
}