package dev.bober.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.bober.database.entity.OfferEntity

@Dao
interface OfferDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOffers(offers: List<OfferEntity>)

    @Query("SELECT * FROM offers")
    suspend fun getOffers(): List<OfferEntity>

    @Query("SELECT * FROM offers WHERE id = :id")
    suspend fun getOffer(id: String): OfferEntity
}