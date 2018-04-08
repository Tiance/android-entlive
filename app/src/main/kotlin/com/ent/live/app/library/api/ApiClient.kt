package com.ent.live.app.library.api

import com.ent.live.app.model.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("/user/{id}")
    fun user(@Path("id") id: Int): Observable<User>

    @GET("/users")
    fun users(): Observable<List<User>>
}