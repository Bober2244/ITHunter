package dev.bober.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.bober.database.dao.OfferDao
import dev.bober.database.dao.VacancyDao
import dev.bober.database.entity.OfferEntity
import dev.bober.database.entity.VacancyEntity

@Database(
    entities = [
        OfferEntity::class,
        VacancyEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract val offerDao: OfferDao
    abstract val vacancyDao: VacancyDao
}