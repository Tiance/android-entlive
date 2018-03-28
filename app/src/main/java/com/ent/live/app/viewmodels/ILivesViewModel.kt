package com.ent.live.app.viewmodels

import com.ent.live.library.IViewModel
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

interface ILivesViewModel : IViewModel {
    val inputs: LivesViewModelInputs
    val outputs: LivesViewModelOutputs
}

interface LivesViewModelInputs {
    fun login()
}

interface LivesViewModelOutputs {
    val loginResult: Observable<Boolean>
}

class LivesViewModel : LivesViewModelInputs, LivesViewModelOutputs, ILivesViewModel {

    private val loginSubject = PublishSubject.create<Boolean>()

    override val inputs: LivesViewModelInputs
        get() = this
    override val outputs: LivesViewModelOutputs
        get() = this

    /*inputs*/
    override fun login() {
        loginSubject.onNext(false)
    }

    override val loginResult: Observable<Boolean>
        get() = loginSubject
}