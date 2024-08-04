package database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuild() : RaceDatabase {
    val dbFile = NSHomeDirectory() + ("/race.db")
    return Room.databaseBuilder<RaceDatabase>(
        name = dbFile,
        factory = { RaceDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
        .fallbackToDestructiveMigration(true)
        .build()
}