package com.cibaka.main.ui.product.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.cibaka.main.ui.product.fragments.AdditionalInformationFragment
import com.cibaka.main.ui.product.fragments.DescriptionFragment
import com.cibaka.main.ui.product.fragments.ShippingReturnFragment

class ProductInfoPagerAdapter(
    private val mContext: Context,
    private val fm: FragmentManager,
    private var totalTabs: Int
) : FragmentStatePagerAdapter(fm) {

    private val fragments: MutableList<Fragment> = ArrayList()
    private val fragmentTitle: MutableList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        //return fragments[position]
        return when (position) {
            0 -> DescriptionFragment()
            1 -> AdditionalInformationFragment()
            else -> ShippingReturnFragment()
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }

}
