package domain.usecase

import data.repository.RiderRepository

class GetAllRidersUseCase(private val repository: RiderRepository) {
    suspend operator fun invoke() = kotlin.runCatching {
        repository.getAllRiders()
    }
}