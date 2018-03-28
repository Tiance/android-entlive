package com.ent.live.app.views.activity

import android.os.Bundle
import android.util.Log
import com.ent.live.live.R
import com.ent.live.app.viewmodels.LoginViewModel
import com.ent.live.library.*
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable


@ViewModelCreator(ViewModelScope.SINGLETON)
class LoginActivity : BaseActivity<LoginViewModel.ViewModel>() {

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
                    NotificationCenter.default.post(NotificationCenter.Notification("hello", 10))
                }
                .disposedBy(disposeBag)

        val a = Observable.just(0)
        val b = Observable.just("")
        val c = Observable.just(0.33)


    }
}