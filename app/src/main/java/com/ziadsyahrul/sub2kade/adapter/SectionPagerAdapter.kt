package com.ziadsyahrul.sub2kade.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ziadsyahrul.sub2kade.MVP.match.next.NextMatchFragment
import com.ziadsyahrul.sub2kade.MVP.match.prev.PreviousMatchFragment
import com.ziadsyahrul.sub2kade.R

class SectionPagerAdapter(private val context: Context, val fm:FragmentManager) : FragmentPagerAdapter(fm){

    val PAGE_TITLES = arrayOf(
        R.string.previous_match,
        R.string.next_match
    )

    val page = listOf(
        PreviousMatchFragment(),
        NextMatchFragment()
    )

    override fun getItem(position: Int): Fragment {
        return page[position]
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(PAGE_TITLES[position])
    }
}