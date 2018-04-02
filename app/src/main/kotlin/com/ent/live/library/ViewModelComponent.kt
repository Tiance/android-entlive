package com.ent.live.library

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlin.reflect.KClass


interface ViewModelComponent<out T : ViewModelComponent.ViewModel> {

    val viewModel: T
        get() {
            val cls = this@ViewModelComponent::class.supertypes.first()
            val args = cls.arguments.first()
            val annotationsList = cls.javaClass.annotations

            var scope = ViewModelScope.SINGLETON

            for (item in annotationsList) {
                if (item is Produce) {
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

    companion object {
        val map = mutableMapOf<String, ViewModel>()
    }

    interface ViewModel


    @Open
    class ViewModelActivity<out T : ViewModelComponent.ViewModel> : AppCompatActivity(), ViewModelComponent<T> {

        protected val disposeBag: DisposeBag by lazy {
            DisposeBag(this)
        }

        override fun setContentView(view: View?) {
            super.setContentView(view)
            bindViewModel()

        }

        override fun setContentView(layoutResID: Int) {
            super.setContentView(layoutResID)
            bindViewModel()
        }

        fun bindViewModel() {

        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }

    @Open
    class ViewModelFragment<out T : ViewModelComponent.ViewModel> : Fragment(), ViewModelComponent<T> {
        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)
            bindViewModel()
        }

        fun bindViewModel() {

        }
    }
}