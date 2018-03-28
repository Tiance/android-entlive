package com.ent.live.app.viewmodels

import android.arch.lifecycle.ViewModel
import com.ent.live.library.IViewModel
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

interface ILoginViewModel : IViewModel {
    val inputs: ILoginViewModelInputs
    val outputs: ILoginViewModelOutputs
}

interface ILoginViewModelInputs {
    fun username(value: String)
    fun login()
}

interface ILoginViewModelOutputs {
    val loginResult: Observable<Boolean>
}

class LoginViewModel : ILoginViewModelInputs, ILoginViewModelOutputs, ILoginViewModel {

    private val loginSubject = PublishSubject.create<Boolean>()
    private val usernameSubject = PublishSubject.create<String>()

    override val inputs: ILoginViewModelInputs
        get() = this
    override val outputs: ILoginViewModelOutputs
        get() = this


    /*inputs*/
    override fun login() {
        loginSubject.onNext(false)
    }

    override fun username(value: String) {
        usernameSubject.onNext(value)
    }


    /*outputs*/
    override val loginResult: Observable<Boolean>
        get() = usernameSubject.map { it.length == 3 }


}


class Login2ViewModel : ViewModel(), ILoginViewModelInputs, ILoginViewModelOutputs, ILoginViewModel {
    override val inputs: ILoginViewModelInputs
        get() = this
    override val outputs: ILoginViewModelOutputs
        get() = this

    private val testSubject = PublishSubject.create<Boolean>()

    override fun username(value: String) {
        testSubject.onNext(value.length == 3)
    }

    override fun login() {

    }

    override val loginResult: Observable<Boolean>
        get() = testSubject

}