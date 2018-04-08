package com.ent.live.app.viewmodels.fragment

import com.ent.live.library.ViewModelComponent

interface MeViewModel : ViewModelComponent.ViewModel {
    val inputs: Inputs
    val outputs: Outputs


    interface Inputs {

    }

    interface Outputs {

    }

    class ViewModel : Inputs, Outputs, MeViewModel {
        override val inputs: Inputs
            get() = this
        override val outputs: Outputs
            get() = this

    }


}