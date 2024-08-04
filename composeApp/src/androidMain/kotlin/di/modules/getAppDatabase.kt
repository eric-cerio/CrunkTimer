package di.modules

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import database.RaceDatabase

fun getDatabaseBuild(ctx: Context) :RaceDatabase {
    val dbFile = ctx.getDatabasePath("race.db")
    return Room.databaseBuilder<RaceDatabase>(ctx, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver()).fallbackToDestructiveMigration(true).build()
}