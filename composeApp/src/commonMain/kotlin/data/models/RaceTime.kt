package data.models

data class RaceTime(
    val start: Long= 0L,
    val elapse: Long = 0L,
    val finish: Long = 0L,
    val startTimeFormatted: String = "00:00:00",
    val finishTimeFormatted: String = "00:00:00"
)