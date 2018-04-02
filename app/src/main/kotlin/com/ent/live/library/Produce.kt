package com.ent.live.library

enum class ViewModelScope {
    SINGLETON,
    PROTOTYPE
}

annotation class Produce(val type: ViewModelScope = ViewModelScope.SINGLETON)