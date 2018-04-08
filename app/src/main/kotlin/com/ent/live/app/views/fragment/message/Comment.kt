package com.ent.live.app.views.fragment.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ent.live.app.viewmodels.LoginViewModel
import com.ent.live.library.ViewModelComponent
import com.ent.live.live.R

class Comment : ViewModelComponent.ViewModelFragment<LoginViewModel.ViewModel>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_message_comment, container, false)
    }
}