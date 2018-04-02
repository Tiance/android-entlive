package com.ent.live.app.library

import android.content.Context
import android.content.Intent
import com.ent.live.app.views.activity.MainActivity

enum class LoginReason {
    DEFAULT,
    PREPARE_LIVE
}

class UILoginIntent(private val reason: LoginReason, private val context: Context) : TaskDescription {

    override fun condition(): Boolean {
        return when (reason) {
            LoginReason.DEFAULT -> true
            else -> false
        }
    }

    override fun through() {

    }

    override fun prevent() {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

}