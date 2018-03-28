package com.ent.live.app.library

interface UserDefaults {
    fun <T> setObject(key: String, value: T)
    fun <T> getObject(byKey: String): T
}