package di.modules

import database.getDatabaseBuild
import database.RaceDatabase
import org.koin.dsl.module

actual val platformModule = module {
    single<RaceDatabase> {
        getDatabaseBuild()
    }
}