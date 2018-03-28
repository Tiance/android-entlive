package com.ent.live.library.ext

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.widget.Toast

fun Activity.replaceFragment(containerViewId: Int, fragment: Fragment, tag: String = "") {
    val manager = this.fragmentManager
    manager.beginTransaction().replace(containerViewId, fragment, tag).commit()
}

fun Activity.toast(context: Context, text: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, text, duration).show()
}

fun Activity.toast(context: Context, resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, resId, duration).show()
}