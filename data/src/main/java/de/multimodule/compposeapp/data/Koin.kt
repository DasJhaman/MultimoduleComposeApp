package de.multimodule.compposeapp.data

import de.multimodule.compposeapp.data.api.UserApi
import de.multimodule.compposeapp.data.repo.features.users.UserRepositoryImp
import de.multimodule.compposeapp.domain_layer.features.userlist.features.users.UserRepository
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.binds
import de.multimodule.compposeapp.domain_layer.features.userlist.features.users.GetUsersListUseCase
import io.ktor.client.engine.okhttp.OkHttp

fun initKoin(additionalModules: List<Module>): KoinApplication {
    return startKoin {
        modules(additionalModules + coreModule + apiModule)
    }
}

private val coreModule = module {
    single {
        HttpClient(engine = get()) {
            expectSuccess = true
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                })
            }
            defaultRequest {
                url(BuildConfig.API_BASE_URL)
            }

        }
    }
}

private val apiModule = module {
    single {
        OkHttp.create()
    }
    singleOf(::UserApi)
    singleOf(::GetUsersListUseCase)
    singleOf(::UserRepositoryImp) binds arrayOf(UserRepository::class)

}

