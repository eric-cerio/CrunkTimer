package data.local

import data.models.Rider

interface RiderLocalRepository {
    suspend fun getAllRiders(): List<Rider>

    suspend fun saveAllRiders(riders: List<Rider>): Boolean

    suspend fun deleteAllRiders(): Boolean

}