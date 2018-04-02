package com.ent.live.library

import android.app.Activity

interface UIControllerTaskType<R : Activity, T : Activity> {
    fun <R> cls(): Class<R>
    /*目标Controller*/
    fun <T : Activity> targetCls(): Class<T>

    /*当前Controller引用*/
    var block: (Activity) -> Void


    var Activity.openStrobe: () -> Void
}


fun Activity.updateTaskStatus() {

}

fun <R : Activity, T : Activity> Activity.prepareIntent(task: UIControllerTaskType<R, T>) {
    updateTaskStatus()
}

inline fun <reified T : Any> T.cls(): Class<T> = T::class.java
