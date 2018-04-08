package com.ent.live.app.viewmodels.activity

import android.support.v4.app.Fragment
import com.ent.live.app.views.fragment.message.Container
import com.ent.live.library.ViewModelComponent
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

interface MainTabViewModel : ViewModelComponent.ViewModel {

    val inputs: Inputs
    val outputs: Outputs


    interface Inputs {
        fun tabSelected(id: Int)
    }

    interface Outputs {
        val tabSelected: Observable<Fragment>
    }

    class ViewModel : Inputs, Outputs, MainTabViewModel {

        private val tabSelectedSubject = PublishSubject.create<Fragment>()


        override val inputs: Inputs
            get() = this
        override val outputs: Outputs
            get() = this

        /*Inputs*/
        override fun tabSelected(id: Int) {
            tabSelectedSubject.onNext(Container())
        }

        override val tabSelected: Observable<Fragment>
            get() = tabSelectedSubject
    }
}