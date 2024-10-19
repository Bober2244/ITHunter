package dev.bober.database.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import dev.bober.database.entity.AddressEntity
import dev.bober.database.entity.ExperienceEntity
import dev.bober.database.entity.SalaryEntity
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

@ProvidedTypeConverter
class Converters(
    private val json: Json
) {

    @TypeConverter
    fun addressToString(address: AddressEntity) : String {
        return json.encodeToString(serializer(), address)
    }

    @TypeConverter
    fun stringToAddress(line: String) : AddressEntity {
        return json.decodeFromString(serializer(), line)
    }

    @TypeConverter
    fun experienceToString(experience: ExperienceEntity) : String {
        return json.encodeToString(serializer(), experience)
    }

    @TypeConverter
    fun stringToExperience(line: String) : ExperienceEntity {
        return json.decodeFromString(serializer(), line)
    }

    @TypeConverter
    fun salaryToString(salary: SalaryEntity) : String {
        return json.encodeToString(serializer(), salary)
    }

    @TypeConverter
    fun stringToSalary(line: String) : SalaryEntity {
        return json.decodeFromString(serializer(), line)
    }

    @TypeConverter
    fun stringListToString(list: List<String>) : String {
        return json.encodeToString(serializer(), list)
    }

    @TypeConverter
    fun stringToStringList(line: String) : List<String> {
        return json.decodeFromString(serializer(), line)
    }
}