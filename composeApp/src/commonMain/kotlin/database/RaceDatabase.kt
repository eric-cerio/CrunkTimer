package database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import database.converters.RiderTypeConverters
import database.dao.RiderDao
import database.model.RiderDB

@Database(entities = [RiderDB::class], version = 1, exportSchema = false)
@TypeConverters(RiderTypeConverters::class)
abstract class RaceDatabase : RoomDatabase(), DB{
    abstract fun userDao(): RiderDao
    override fun clearAllTables() {
        super.clearAllTables()
    }
}

interface DB {
    fun clearAllTables() {}
}