package di.modules

import data.repository.RiderRepository
import data.repository.RiderRepositoryImpl
import org.koin.dsl.module



val repositoryModule = module {
    single<RiderRepository> { RiderRepositoryImpl(get()) }
}