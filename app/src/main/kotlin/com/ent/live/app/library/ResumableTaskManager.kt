package com.ent.live.app.library


interface TaskDescription {
    fun condition(): Boolean
    fun through()
    fun prevent()
}


class ResumableTaskManager {


    fun add(task: TaskDescription) {
        if (task.condition()) task.through() else task.prevent()
    }


    companion object {
        val default: ResumableTaskManager by lazy {
            ResumableTaskManager()
        }
    }
}