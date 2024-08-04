package database.model

import kotlinx.serialization.Serializable
import data.models.RaceTime

@Serializable
data class RaceTimeDB (
    val start: Long= 0L,
    val elapse: Long = 0L,
    val finish: Long = 0L,
    val startTimeFormatted: String,
    val finishTimeFormatted: String
) {
    fun toDomain(): RaceTime {
        return RaceTime(
            start = this.start,
            elapse = this.elapse,
            finish = this.finish,
            startTimeFormatted = this.startTimeFormatted,
            finishTimeFormatted = this.finishTimeFormatted
        )
    }
}