package com.ent.live.app.views.activity

import android.os.Bundle
import android.preference.PreferenceActivity
import com.ent.live.live.R

class SettingActivity : PreferenceActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.f_me_settings)
    }
}