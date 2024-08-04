package data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


data class Race(
    val raceId: Int = 0,
    val raceName: String,
    val runType: RunType
)

enum class RunType {
    SEEDING,
    FINAL
}
