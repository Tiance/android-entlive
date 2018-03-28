package com.ent.live.app.library

import com.ent.live.client.ClientInterceptor
import com.ent.live.client.oauth.CommonAccessToken
import com.ent.live.client.oauth.OauthAccessTokenType
import com.ent.live.app.library.api.ApiClient
import com.ent.live.app.model.User
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AppEnvironment {
    companion object {
        private val stack = mutableListOf(Environment())

        private val userEventsSubject = PublishSubject.create<UserEvents>()
        private var envType: EnvironmentType = EnvironmentType.DEV
        private val tokenExpiredSubject = PublishSubject.create<Unit>()

        @JvmStatic
        val current: Environment
            get() = stack.last()

        val userEvents: Observable<UserEvents>
            get() = Observable.merge(userEventsSubject, tokenExpiredSubject.map { UserEvents.TOKEN_EXPIRED })

        @JvmStatic
        fun updateUser(user: User) {
            replace(user = user)
        }

        @JvmStatic
        fun auth(accessToken: OauthAccessTokenType) {
            replace(api = generateEnv(accessToken))
        }

        @JvmStatic
        fun switchEnv(type: EnvironmentType) {
            envType = type
            replace(api = generateEnv())
            userEventsSubject.onNext(UserEvents.ENV_CHANGED)
        }

        private fun replace(
                user: User = current.currentUser,
                api: ApiClient = current.api
        ) {
            replace(Environment(user, api))
        }

        private fun replace(environment: Environment) {
            stack.add(environment)
            stack.removeAt(stack.count() - 2)
        }

        private fun generateEnv(accessToken: OauthAccessTokenType = CommonAccessToken("")): ApiClient {
            val client = OkHttpClient.Builder()
                    .addInterceptor(ClientInterceptor(accessToken, tokenExpiredSubject))
                    .build()
            val retrofit = Retrofit.Builder()
                    .baseUrl(envType.serverConfig().apiBaseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            return retrofit.create(ApiClient::class.java)
        }

        /**
         * 持久化恢复数据
         */
        @JvmStatic
        fun fromStorage(userDefaults: UserDefaults): Environment {
            return Environment()
        }
    }
}