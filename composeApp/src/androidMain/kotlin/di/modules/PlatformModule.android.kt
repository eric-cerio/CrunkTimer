package di.modules

import database.RaceDatabase
import org.koin.dsl.module

actual val platformModule = module {
    single<RaceDatabase> {
        getDatabaseBuild(get())
    }
}