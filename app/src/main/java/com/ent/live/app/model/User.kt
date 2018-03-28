package com.ent.live.app.model

data class User(
        val id: Int,
        val login: String) {
    companion object {
        val template: User
            get() = User(0, "Yamazhiki")
    }
}