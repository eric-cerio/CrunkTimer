package domain.usecase

import data.models.Rider
import data.repository.RiderRepository

class SaveAllRidersUserCase(private val repository: RiderRepository) {
    suspend operator fun invoke(list: List<Rider>) = kotlin.runCatching {
        repository.saveAllRiders(list)
    }
}