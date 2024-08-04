package com.crunkdhtimer.models

import data.models.Category
import data.models.Person
import data.models.Race
import data.models.RaceTime

data class Rider(
    val riderNo: Int,
    val riderDetails: Person,
    val category: Category,
    val race: Race,
    val time: RaceTime
)

enum class Category {
    BELOW_19,
    AGE_20_29,
    AGE_30_39,
    AGE_ABOVE_40,
    C_HARD_TAIL,
    C_WOMEN
}

data class Person(
    val name: String,
    val age: String,
    val gender: String?
)
