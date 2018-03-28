package com.ent.live.app.library

import com.ent.live.app.library.api.ApiClient
import com.ent.live.app.library.api.MockApiClient
import com.ent.live.client.IServerConfig
import com.ent.live.client.ServerConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

enum class EnvironmentType {
    SIMULATION,
    DEV,
    PRODUCTION
}

fun EnvironmentType.serverConfig(): IServerConfig {
    return when (this) {
        EnvironmentType.SIMULATION -> ServerConfig.simulation
        EnvironmentType.DEV -> ServerConfig.dev
        else -> ServerConfig.production
    }
}

fun EnvironmentType.api(): ApiClient {
    return when (this) {
        EnvironmentType.SIMULATION -> MockApiClient()
        else -> {
            val retrofit = Retrofit.Builder()
                    .baseUrl(this.serverConfig().apiBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            retrofit.create(ApiClient::class.java)
        }
    }
}