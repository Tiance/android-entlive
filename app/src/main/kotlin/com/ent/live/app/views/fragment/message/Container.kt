package com.ent.live.app.views.fragment.message

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerTitleStrip
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ent.live.app.viewmodels.fragment.MessageContainerViewModel
import com.ent.live.library.ViewModelComponent
import com.ent.live.live.R

class Container : ViewModelComponent.ViewModelFragment<MessageContainerViewModel.ViewModel>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_message_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabStrip: PagerTitleStrip = view.findViewById(R.id.message_container_strip)
        val pager: ViewPager = view.findViewById(R.id.message_container_body)
        pager.adapter = MessageFragmentAdapter(childFragmentManager)
    }

    class MessageFragmentAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
        private val titles = arrayListOf("私信", "评论", "打赏我的", "喜欢我的")
        private val fragments = arrayListOf(PM(), Comment(), PM(), PM())
        override fun getItem(p0: Int): Fragment {
            return fragments[p0]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }

    }
}