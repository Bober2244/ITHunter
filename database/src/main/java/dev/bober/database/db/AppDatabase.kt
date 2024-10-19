package dev.bober.database.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dev.bober.database.converter.Converters
import dev.bober.database.dao.OfferDao
import dev.bober.database.dao.VacancyDao
import dev.bober.database.entity.OfferEntity
import dev.bober.database.entity.VacancyEntity

@Database(
    entities = [
        OfferEntity::class,
        VacancyEntity::class],
    version = 2,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ]
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val offerDao: OfferDao
    abstract val vacancyDao: VacancyDao
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE vacancies ADD COLUMN questions TEXT NOT NULL DEFAULT ''")
        db.execSQL("ALTER TABLE vacancies ADD COLUMN responsibilities TEXT NOT NULL DEFAULT ''")
        db.execSQL("ALTER TABLE vacancies ADD COLUMN description TEXT DEFAULT ''")
    }
}