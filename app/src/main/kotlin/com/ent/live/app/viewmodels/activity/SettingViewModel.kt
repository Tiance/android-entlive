package com.ent.live.app.viewmodels.activity

import com.ent.live.library.ViewModelComponent

interface SettingViewModel : ViewModelComponent.ViewModel {

    val inputs: Inputs
    val outputs: Outputs

    interface Inputs {
        fun changeNotification(boolean: Boolean)
        fun clearCache()
    }

    interface Outputs {

    }

    class ViewModel : Inputs, Outputs, SettingViewModel {


        override val inputs: Inputs
            get() = this
        override val outputs: Outputs
            get() = this

        /*inputs*/
        override fun changeNotification(boolean: Boolean) {

        }

        override fun clearCache() {

        }

    }
}