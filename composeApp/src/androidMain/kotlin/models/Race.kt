package com.crunkdhtimer.models

import data.models.RunType

class Race(
    val raceId: Int,
    val raceName: String,
    val runType: RunType
)

enum class RunType {
    SEEDING,
    FINAL
}
