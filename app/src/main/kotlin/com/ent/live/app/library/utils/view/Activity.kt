package com.ent.live.app.library.utils.view

import android.app.Activity
import com.ent.live.app.library.ResumableTaskManager
import com.ent.live.app.library.TaskDescription

fun Activity.s(task: TaskDescription) {
    ResumableTaskManager.default.add(task)
}