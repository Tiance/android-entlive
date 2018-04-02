package com.ent.live.app.library

interface ResumableTask {

    /*终止的条件*/
    val prevent: () -> Boolean

    /*如果条件满足(可继续)这调用*/
    fun resume(task: () -> Unit)
}