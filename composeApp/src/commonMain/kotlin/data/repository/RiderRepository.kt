package data.repository

import data.models.Rider

interface RiderRepository {
    suspend fun getAllRiders(): List<Rider>

    suspend fun saveAllRiders(list: List<Rider>): Boolean
}