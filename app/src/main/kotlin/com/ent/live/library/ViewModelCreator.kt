package com.ent.live.library

enum class ViewModelScope {
    SINGLETON,
    PROTOTYPE
}

annotation class ViewModelCreator(val type: ViewModelScope = ViewModelScope.SINGLETON)