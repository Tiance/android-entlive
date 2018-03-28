package com.ent.live.app.views.activity

import android.os.Bundle
import android.util.Log
import com.ent.live.R
import com.ent.live.app.viewmodels.LoginViewModel
import com.ent.live.library.BaseActivity
import com.ent.live.library.Notification
import com.ent.live.library.NotificationCenter
import com.ent.live.library.disposedBy
import com.jakewharton.rxbinding2.widget.RxTextView

class LoginActivity : BaseActivity<LoginViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    override fun bindViewModel() {

        RxTextView.textChanges(findViewById(R.id.login_username))
                .map(CharSequence::toString)
                .subscribe { viewModel.inputs.username(it) }
                .disposedBy(disposeBag)

        NotificationCenter.default.notification
                .subscribe { Log.d("NotificationCenter", "Hello") }
                .disposedBy(disposeBag)

        viewModel.outputs.loginResult
                .subscribe {
                    Log.d("LoginViewModel", it.toString())
                    NotificationCenter.default.post(Notification("hello", 10))
                }
                .disposedBy(disposeBag)
    }
}