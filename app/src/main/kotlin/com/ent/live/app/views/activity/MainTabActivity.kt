package com.ent.live.live

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main_tab.*

class MainTabActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.main_tab_recommend -> {
                message.setText(R.string.main_tab_recommend)
                return@OnNavigationItemSelectedListener true
            }
            R.id.main_tab_square -> {
                message.setText(R.string.main_tab_square)
                return@OnNavigationItemSelectedListener true
            }
            R.id.main_tab_message -> {
                message.setText(R.string.main_tab_message)
                return@OnNavigationItemSelectedListener true
            }
            else -> {
                message.setText(R.string.main_tab_me)
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tab)
        val container: FrameLayout = findViewById(R.id.container)
        

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}