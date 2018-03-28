package com.ent.live.app.views.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.ent.live.R
import com.ent.live.app.library.AppEnvironment
import com.ent.live.app.library.UserEvents
import com.ent.live.client.oauth.CommonAccessToken
import com.jakewharton.rxbinding2.view.RxView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppEnvironment.auth(CommonAccessToken(""))
        AppEnvironment.userEvents
                .filter { it == UserEvents.TOKEN_EXPIRED }
                .subscribe { rlt ->
                    Log.e("Token", "expired")
                }

        RxView.clicks(findViewById(R.id.button))
                .subscribe {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
    }
}
