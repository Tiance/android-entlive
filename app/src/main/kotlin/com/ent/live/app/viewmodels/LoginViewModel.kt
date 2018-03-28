package com.ent.live.app.viewmodels

import com.ent.live.library.BaseViewModel
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

interface LoginViewModel : BaseViewModel {

    interface Inputs {
        fun username(value: String)
        fun login()
    }

    interface Outputs {
        val loginResult: Observable<Boolean>
    }


    class ViewModel : Inputs, Outputs, LoginViewModel {

        private val loginSubject = PublishSubject.create<Boolean>()
        private val usernameSubject = PublishSubject.create<String>()

        val inputs: Inputs
            get() = this
        val outputs: Outputs
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
}