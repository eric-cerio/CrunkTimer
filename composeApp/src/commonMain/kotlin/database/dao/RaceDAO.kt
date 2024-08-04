package database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import database.model.RiderDB

@Dao
interface RiderDao {
    @Upsert
    suspend fun insert(rider: RiderDB): Long

    @Query("SELECT * FROM ${RiderDB.RIDER_TABLE_NAME} WHERE id = :id")
    suspend fun getRiderById(id: Int): RiderDB?

    @Delete
    suspend fun delete(rider: RiderDB)

    @Query("DELETE FROM ${RiderDB.RIDER_TABLE_NAME}")
    suspend fun deleteAll()

    @Query("DELETE FROM ${RiderDB.RIDER_TABLE_NAME} WHERE id = :id")
    suspend fun deleteById(id: Int): Int

    @Query("SELECT * FROM ${RiderDB.RIDER_TABLE_NAME}")
    suspend fun getAllRiders(): List<RiderDB>
}