package com.ent.live.library.ext

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

fun AppCompatActivity.replaceFragment(containerViewId: Int, fragment: Fragment, tag: String = "") {
    val manager = this.supportFragmentManager
    val transition = manager.beginTransaction()
    transition.add(containerViewId, fragment, tag)
    transition.commit()
}

fun Activity.toast(context: Context, text: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, text, duration).show()
}

fun Activity.toast(context: Context, resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, resId, duration).show()
}