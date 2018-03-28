package com.ent.live.library

import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlin.reflect.KClass


open class BaseActivity<out T : IViewModel> : AppCompatActivity() {

    protected val disposeBag = DisposeBag(this)

    val viewModel: T by lazy {
        val key = this@BaseActivity::class
                .supertypes.first()
                .arguments.first()
                .type.toString()

        val rlt = map[key]
        @Suppress("UNCHECKED_CAST")
        if (rlt != null) return@lazy rlt as T

        @Suppress("UNCHECKED_CAST")
        val value = (this@BaseActivity::class
                .supertypes.first()
                .arguments.first()
                .type!!.classifier as KClass<*>)
                .constructors.take(1)
                .first().call() as T
        map[key] = value
        return@lazy value
    }

    override fun setContentView(view: View?) {
        super.setContentView(view)
        bindViewModel()
        bindStyle()

    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        bindViewModel()
        bindStyle()
    }

    open fun bindViewModel() {

    }

    open fun bindStyle() {

    }

    companion object {
        val map = mutableMapOf<String, IViewModel>()

    }

}
