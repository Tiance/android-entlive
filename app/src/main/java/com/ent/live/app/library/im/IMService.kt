package com.ent.live.app.library.im

import io.reactivex.Observable

data class Message(val id: Message,
                   val type: Int)

data class IMUserParam(
        val id: String,
        val login: String,
        val appId: String)

interface IMService {

    val receieveMessage: Observable<Message>

    fun login()
    fun logout()
}