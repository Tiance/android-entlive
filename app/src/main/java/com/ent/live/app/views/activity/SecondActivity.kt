package com.ent.live.app.views.activity

import android.os.Bundle
import android.util.Log
import com.ent.live.R
import com.ent.live.app.viewmodels.SecondViewModel
import com.ent.live.library.BaseActivity
import com.ent.live.library.disposedBy
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class SecondActivity : BaseActivity<SecondViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe { Log.d("Dispose", it.toString()) }
                .disposedBy(disposeBag)
    }

    override fun bindViewModel() {
        viewModel.outputs.result.subscribe { Log.d("H", "H") }
        viewModel.inputs.viewDidLoad()
    }

}