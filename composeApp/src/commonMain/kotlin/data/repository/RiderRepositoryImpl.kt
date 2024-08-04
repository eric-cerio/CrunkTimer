package data.repository

import data.models.Rider

class RiderRepositoryImpl (private val riderLocalRepository: RiderRepository): RiderRepository{
    override suspend fun getAllRiders(): List<Rider> {
        return riderLocalRepository.getAllRiders()
    }

    override suspend fun saveAllRiders(list: List<Rider>): Boolean {
        return riderLocalRepository.saveAllRiders(list)
    }
}