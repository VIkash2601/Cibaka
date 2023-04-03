package com.foundrytreasure.main.ui.product.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ProductInfoPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val fragments: MutableList<Fragment> = ArrayList()
    private val fragmentTitle: MutableList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragments[position]
        /*return when (position) {
            0 -> DescriptionFragment()
            1 -> AdditionalInformationFragment()
            else -> ShippingReturnFragment()
        }*/
    }

    override fun getPageTitle(position: Int) = fragmentTitle[position]

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        fragmentTitle.add(title)
    }

    override fun getCount(): Int {
        return fragments.size
    }

}
