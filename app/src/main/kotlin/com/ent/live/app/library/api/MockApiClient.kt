package com.ent.live.app.library.api

import com.ent.live.app.model.User
import io.reactivex.Observable

class MockApiClient : ApiClient {
    override fun user(id: Int): Observable<User> {
        return Observable.just(User.template)
    }
}