package com.ent.live.app.viewmodels

import com.ent.live.library.IViewModel
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

interface ISecondViewModel : IViewModel {
    val inputs: ISecondViewModelInputs
    val outputs: ISecondViewModelOutputs
}

interface ISecondViewModelInputs {
    fun viewDidLoad()
}

interface ISecondViewModelOutputs {
    val result: Observable<Unit>
}

class SecondViewModel : ISecondViewModelInputs, ISecondViewModelOutputs, ISecondViewModel {
    private val resultSubject = PublishSubject.create<Unit>()


    override fun viewDidLoad() {
        resultSubject.onNext(Unit)
    }

    override val result: Observable<Unit>
        get() = resultSubject
    override val inputs: ISecondViewModelInputs
        get() = this
    override val outputs: ISecondViewModelOutputs
        get() = this


}