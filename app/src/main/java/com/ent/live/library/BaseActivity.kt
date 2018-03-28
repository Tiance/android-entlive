package com.ent.live.library

import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlin.reflect.KClass


open class BaseActivity<out T : IViewModel> : AppCompatActivity() {

    protected val disposeBag = DisposeBag(this)

    val viewModel: T
        get() {
            val cls = this@BaseActivity::class
                    .supertypes.first()
            val args = cls.arguments.first()
            val annotationsList = cls.javaClass.annotations

            var scope = ViewModelScope.SINGLETON
            for (item in annotationsList) {
                if (item is ViewModelCreator) {
                    scope = item.type
                    break
                }
            }
            (args.type!!.classifier as KClass<*>).constructors.take(1)
                    .first()
                    .call()

            @Suppress("UNCHECKED_CAST")
            when (scope) {
                ViewModelScope.PROTOTYPE -> {
                    return (args.type!!.classifier as KClass<*>).constructors.take(1)
                            .first()
                            .call() as T
                }
                else -> {
                    val key = args.type.toString()
                    var rlt = map[key]
                    if (rlt == null) rlt = (args.type!!.classifier as KClass<*>).constructors.take(1)
                            .first()
                            .call() as T
                    map[key] = rlt
                    return rlt as T
                }
            }
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
