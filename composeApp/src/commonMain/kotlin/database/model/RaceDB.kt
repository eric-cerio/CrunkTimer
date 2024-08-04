package database.model

import kotlinx.serialization.Serializable
import data.models.Race
import data.models.RunType

@Serializable
data class RaceDB(
    val raceId: Int = 0,
    val raceName: String,
    val runType: RunTypeDB
) {
    fun toDomain(): Race {
        return Race(
            raceId = this.raceId,
            raceName = this.raceName,
            runType = RunType.entries[this.runType.ordinal]
        )
    }
}

@Serializable
enum class RunTypeDB {
    SEEDING,
    FINAL
}
