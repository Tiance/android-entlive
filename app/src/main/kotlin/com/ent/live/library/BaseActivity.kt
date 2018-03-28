package com.ent.live.library

import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlin.reflect.KClass

@Open
class BaseActivity<out T : IViewModel> : AppCompatActivity() {

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

            val gen: () -> T = {
                @Suppress("UNCHECKED_CAST")
                (args.type!!.classifier as KClass<*>).constructors.take(1).first().call() as T
            }

            @Suppress("UNCHECKED_CAST")
            return when (scope) {
                ViewModelScope.PROTOTYPE -> gen.invoke()
                else -> {
                    val key = args.type.toString()
                    if (map[key] == null) {
                        map[key] = gen.invoke()
                    }
                    map[key] as T
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

    fun bindViewModel() {

    }

    fun bindStyle() {

    }

    companion object {
        val map = mutableMapOf<String, IViewModel>()

    }

}
