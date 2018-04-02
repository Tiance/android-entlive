package com.ent.live.app.library

import com.ent.live.app.library.api.ApiClient
import com.ent.live.app.model.User
import com.google.gson.Gson

class Environment(
        val currentUser: User = User.template,
        val api: ApiClient = EnvironmentType.DEV.api(),
        val gson: Gson = Gson()
) {
    companion object {
    }
}