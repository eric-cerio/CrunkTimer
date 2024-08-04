package database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import data.models.Category
import data.models.Person
import data.models.Rider

@Entity(tableName = RiderDB.RIDER_TABLE_NAME)
@Serializable
data class RiderDB (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val riderNo: Int,
    val riderDetails: PersonDB,
    val category: CategoryDB,
    val race: RaceDB,
    val time: RaceTimeDB
) {
    companion object {
        const val RIDER_TABLE_NAME = "rider"
    }

    fun toDomain(): Rider {
        return Rider(
            id = this.id,
            riderNo = this.riderNo,
            riderDetails = this.riderDetails.toDomain(),
            category =  Category.entries[this.category.ordinal],
            race = this.race.toDomain(),
            time = this.time.toDomain()
        )
    }
}
@Serializable
enum class CategoryDB {
    BELOW_19,
    AGE_20_29,
    AGE_30_39,
    AGE_ABOVE_40,
    C_HARD_TAIL,
    C_WOMEN
}

@Serializable
data class PersonDB (
    val name: String,
    val age: Int,
    val gender: String
) {
    fun toDomain(): Person {
        return Person(
            name = this.name,
            age = this.age,
            gender = this.gender
        )
    }
}
