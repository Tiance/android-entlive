package com.ent.live.app.library.livestream

import io.reactivex.Observable

interface LiveStreamService {
    fun login(): Observable<Int>
    fun logout(): Observable<Int>
}