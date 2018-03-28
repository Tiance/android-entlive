package com.ent.live.app.library

import com.ent.live.app.library.api.ApiClient
import com.ent.live.app.model.User

class Environment(
        val currentUser: User = User.template,
        val api: ApiClient = EnvironmentType.DEV.api()
) {
    companion object {
    }
}