package database.converters

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import kotlinx.serialization.json.Json
import database.model.CategoryDB
import database.model.PersonDB
import database.model.RaceDB
import database.model.RaceTimeDB
import database.model.RiderDB
import database.model.RunTypeDB

class RiderTypeConverters {

    @TypeConverter
    fun riderDBToString(riderDB: RiderDB) : String {
        return Json.encodeToString(RiderDB.serializer(), riderDB)
    }

    @TypeConverter
    fun riderDBFromString(value: String) : RiderDB {
        return Json.decodeFromString(RiderDB.serializer(), value)
    }

    @TypeConverter
    fun personDBToString(riderDetails: PersonDB) : String {
        return Json.encodeToString(PersonDB.serializer(), riderDetails)
    }

    @TypeConverter
    fun personDBFromString(value: String) : PersonDB {
        return Json.decodeFromString(PersonDB.serializer(), value)
    }

    @TypeConverter
    fun categoryDBToInt(category: CategoryDB) : Int {
        return category.ordinal
    }

    @TypeConverter
    fun categoryDBFromString(value: Int) : CategoryDB {
        return enumValues<CategoryDB>()[value]
    }


    @TypeConverter
    fun raceDBToString(race: RaceDB) : String {
        return Json.encodeToString(RaceDB.serializer(), race)
    }

    @TypeConverter
    fun raceDBFromString(value: String) : RaceDB {
        return Json.decodeFromString(RaceDB.serializer(), value)
    }

    @TypeConverter
    fun raceTimeDBToString(time: RaceTimeDB) : String {
        return Json.encodeToString(RaceTimeDB.serializer(), time)
    }

    @TypeConverter
    fun raceTimeDBFromString(value: String) : RaceTimeDB {
        return Json.decodeFromString(RaceTimeDB.serializer(), value)
    }

    @TypeConverters
    fun runTypeDBToString(type: RunTypeDB) : Int {
        return type.ordinal
    }

    @TypeConverter
    fun runTypeDBFromString(value: Int) : RunTypeDB {
        return enumValues<RunTypeDB>()[value]
    }
}