package com.ent.live.live

import android.os.Bundle
import com.ent.live.app.viewmodels.activity.MainTabViewModel
import com.ent.live.library.Produce
import com.ent.live.library.ViewModelComponent
import com.ent.live.library.ViewModelScope
import com.ent.live.library.ext.replaceFragment
import com.jakewharton.rxbinding2.support.design.widget.RxBottomNavigationView


@Produce(ViewModelScope.PROTOTYPE)
class MainTabActivity : ViewModelComponent.ViewModelActivity<MainTabViewModel.ViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tab)
    }

    override fun bindViewModel() {
        RxBottomNavigationView.itemSelections(findViewById(R.id.navigation))
                .subscribe { viewModel.tabSelected(it.itemId) }

        viewModel.outputs.tabSelected
                .subscribe {
                    replaceFragment(R.id.container, it)
                }
    }
}