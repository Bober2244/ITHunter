package dev.bober.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.bober.database.entity.VacancyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VacancyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVacancies(vacancies: List<VacancyEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVacancy(vacancy: VacancyEntity)

    @Query("SELECT * FROM vacancies")
    fun getVacancies(): Flow<List<VacancyEntity>>

    @Query("SELECT * FROM vacancies WHERE id = :id")
    suspend fun getVacancy(id: String): VacancyEntity

    @Query("SELECT * FROM vacancies WHERE isFavorite = 1")
    fun getFavorites(): Flow<List<VacancyEntity>>

    @Query("DELETE FROM vacancies WHERE id = :id")
    suspend fun removeFavorite(id: String)

    @Query("SELECT COUNT(*) FROM vacancies WHERE isFavorite = 1")
    fun getFavoriteCount(): Flow<Int>
}