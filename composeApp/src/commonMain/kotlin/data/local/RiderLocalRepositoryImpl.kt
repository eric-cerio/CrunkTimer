package data.local

import database.RaceDatabase
import data.models.Rider
import database.model.CategoryDB
import database.model.PersonDB
import database.model.RaceDB
import database.model.RaceTimeDB
import database.model.RiderDB
import database.model.RunTypeDB

class RiderLocalRepositoryImpl (private val riderDatabase: RaceDatabase): RiderLocalRepository {
    override suspend fun getAllRiders(): List<Rider> {
        return riderDatabase.userDao().getAllRiders()
            .map {
                it.toDomain()
            }
    }

    override suspend fun saveAllRiders(riders: List<Rider>): Boolean {
        riderDatabase.userDao().deleteAll()
        riders.forEach {
            val result = riderDatabase.userDao().insert(
                 RiderDB(
                     id = it.id,
                     riderNo = it.riderNo,
                     riderDetails = PersonDB(
                         name = it.riderDetails.name,
                         age = it.riderDetails.age,
                        gender = it.riderDetails.gender
                     ),
                     category = CategoryDB.entries[it.category.ordinal],
                     race = RaceDB(
                         raceId = it.race.raceId,
                         raceName = it.race.raceName,
                         runType = RunTypeDB.entries[it.race.runType.ordinal]
                     ),
                     time = RaceTimeDB(
                         start = it.time.start,
                         elapse = it.time.elapse,
                         finish = it.time.finish,
                         startTimeFormatted = it.time.startTimeFormatted,
                         finishTimeFormatted = it.time.finishTimeFormatted
                     )
                 )
             )
         }
        return riderDatabase.userDao().getAllRiders().size == riders.size
    }

    override suspend fun deleteAllRiders(): Boolean {
        TODO("Not yet implemented")
    }
}