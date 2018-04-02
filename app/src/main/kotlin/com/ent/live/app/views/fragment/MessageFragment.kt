package com.ent.live.app.views.fragment

import com.ent.live.app.viewmodels.fragment.MessageViewModel
import com.ent.live.library.Produce
import com.ent.live.library.ViewModelComponent
import com.ent.live.library.ViewModelScope

@Produce(ViewModelScope.SINGLETON)
class MessageFragment : ViewModelComponent.ViewModelFragment<MessageViewModel.ViewModel>() {
}