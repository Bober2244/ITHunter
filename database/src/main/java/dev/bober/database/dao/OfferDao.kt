package dev.bober.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.bober.database.entity.OfferEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OfferDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOffers(offers: List<OfferEntity>)

    @Query("SELECT * FROM offers")
    fun getOffers(): Flow<List<OfferEntity>>

    @Query("SELECT * FROM offers WHERE id = :id")
    suspend fun getOffer(id: String): OfferEntity
}