package com.cibaka.main.ui.product

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cibaka.R
import com.cibaka.databinding.FragmentProductDetailsBinding
import com.cibaka.main.ui.product.adapter.CustomSpinnerAdapter
import com.cibaka.main.ui.product.adapter.ProductImagesAdapter
import com.cibaka.main.ui.product.adapter.ProductInfoPagerAdapter
import com.cibaka.main.ui.product.dto.Size
import com.google.android.material.tabs.TabLayout

class ProductDetailsFragment : Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null

    private val binding get() = _binding!!
    private var mActivity: Activity? = null
    private var sizeChart: ArrayList<Size> = ArrayList()
    private var individualPrice = "8400"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        mActivity = requireActivity()
        setupSizeSpinner()
        setupProductImgViewPager()
        setupPrice()
        setupProductInfo()
    }

    private fun setupPrice() {

        binding.tvProductPrice.text = getString(R.string.text_product_price_total, "8400")
        binding.ivAddItem.setOnClickListener {
            val itemCount = binding.tvItemCount.text.toString().trim().toInt() + 1
            binding.tvItemCount.text = itemCount.toString()
            binding.ivRemoveItem.isEnabled = true
            val totalPrice = individualPrice.toInt().times(itemCount)
            binding.tvProductPrice.text =
                getString(R.string.text_product_price_total, totalPrice.toString())
        }
        binding.ivRemoveItem.setOnClickListener {
            val itemCount = binding.tvItemCount.text.toString().trim().toInt() - 1
            if (itemCount <= 1) {
                binding.tvItemCount.text = "1"
                binding.ivRemoveItem.isEnabled = false
                binding.tvProductPrice.text = getString(R.string.text_product_price_total, "0")
            } else {
                binding.ivRemoveItem.isEnabled = true
                binding.tvItemCount.text = itemCount.toString()
                val currentPrice =
                    binding.tvProductPrice.text.toString().trim().filter { it.isDigit() }
                Log.e("CartItemAdapter", "onBindViewHolder: $currentPrice")
                val totalPrice = currentPrice.toLong().minus(individualPrice.toInt())
                Log.e("CartItemAdapter", "onBindViewHolder: $totalPrice")
                binding.tvProductPrice.text =
                    getString(R.string.text_product_price_total, totalPrice.toString())
            }
        }
    }

    private fun setupProductImgViewPager() {
        binding.vpProductImages.adapter = ProductImagesAdapter(mActivity!!)
    }

    private fun setupSizeSpinner() {
        sizeChart.add(0, Size(1, getString(R.string.text_small)))
        sizeChart.add(1, Size(2, getString(R.string.text_medium)))
        sizeChart.add(2, Size(3, getString(R.string.text_large)))
        sizeChart.add(3, Size(4, getString(R.string.text_extra_large)))
        binding.spSize.adapter = CustomSpinnerAdapter(mActivity!!, sizeChart)
        binding.spSize.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                when (sizeChart[position].size) {
                    getString(R.string.text_small) -> {
                        individualPrice = "8400"
                        binding.tvProductPrice.text =
                            getString(R.string.text_product_price_total, individualPrice)
                        binding.tvItemCount.text = "1"
                    }
                    getString(R.string.text_medium) -> {
                        individualPrice = "9400"
                        binding.tvProductPrice.text =
                            getString(R.string.text_product_price_total, individualPrice)
                        binding.tvItemCount.text = "1"
                    }
                    getString(R.string.text_large) -> {
                        individualPrice = "10400"
                        binding.tvProductPrice.text =
                            getString(R.string.text_product_price_total, individualPrice)
                        binding.tvItemCount.text = "1"
                    }
                    getString(R.string.text_extra_large) -> {
                        individualPrice = "11400"
                        binding.tvProductPrice.text =
                            getString(R.string.text_product_price_total, individualPrice)
                        binding.tvItemCount.text = "1"
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}

        }
    }

    private fun setupProductInfo() {
        binding.tabLay.removeAllTabs()
        binding.tabLay.addTab(
            binding.tabLay.newTab().setText(getString(R.string.title_description))
        )
        binding.tabLay.addTab(
            binding.tabLay.newTab().setText(getString(R.string.title_additional_info))
        )
        binding.tabLay.addTab(
            binding.tabLay.newTab().setText(getString(R.string.title_shipping_returns))
        )
        binding.tabLay.tabTextColors = ContextCompat.getColorStateList(mActivity!!, R.color.white)
        binding.tabLay.setSelectedTabIndicatorColor(
            ContextCompat.getColor(
                mActivity!!,
                R.color.white
            )
        )
        binding.tabLay.tabMode = TabLayout.MODE_FIXED
        binding.tabLay.tabGravity = TabLayout.GRAVITY_FILL

        val adapter =
            ProductInfoPagerAdapter(
                requireContext(),
                requireFragmentManager(),
                binding.tabLay.tabCount
            )
        binding.vpProductInfo.adapter = adapter

        binding.tabLay.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.vpProductInfo.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        binding.vpProductInfo.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(binding.tabLay)
        )
        binding.tabLay.setupWithViewPager(binding.vpProductInfo)

        binding.vpProductInfo.setOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                binding.vpProductInfo.currentItem = position
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}