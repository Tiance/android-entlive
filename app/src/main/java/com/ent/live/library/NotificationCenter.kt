package com.ent.live.library

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

data class Notification<T>(
        val name: String,
        val data: T)

class NotificationCenter {
    private val subject = PublishSubject.create<Notification<*>>()

    val notification: Observable<Notification<*>>
        get() = subject


    fun <T> post(notification: Notification<T>) {
        subject.onNext(notification)
    }


    companion object {
        val default: NotificationCenter by lazy {
            NotificationCenter()
        }
    }
}