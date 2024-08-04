package di

import di.modules.platformModule
import di.modules.repositoryModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            platformModule,
            repositoryModule
        )
    }


//using in iOS
fun initKoin() = initKoin {}