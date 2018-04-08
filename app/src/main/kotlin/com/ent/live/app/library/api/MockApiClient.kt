package com.ent.live.app.library.api

import com.ent.live.app.model.User
import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

class MockApiClient : ApiClient {
    override fun user(id: Int): Observable<User> {
        return Observable.just(User.template)
    }

    override fun users(): Observable<List<User>> {
        return arrayListOf(listOf(User.template)).toObservable()
    }
}