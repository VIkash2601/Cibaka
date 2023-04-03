package com.foundrytreasure.main.ui.product

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.foundrytreasure.R
import com.foundrytreasure.databinding.FragmentProductDetailsBinding
import com.foundrytreasure.main.ui.product.adapter.CustomSpinnerAdapter
import com.foundrytreasure.main.ui.product.adapter.ProductImagesAdapter
import com.foundrytreasure.main.ui.product.adapter.ProductInfoPagerAdapter
import com.foundrytreasure.main.ui.product.adapter.ProductsAdapter
import com.foundrytreasure.main.ui.product.dto.Size
import com.foundrytreasure.main.ui.product.fragments.AdditionalInformationFragment
import com.foundrytreasure.main.ui.product.fragments.DescriptionFragment
import com.foundrytreasure.main.ui.product.fragments.ShippingReturnFragment
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
        setupAlsoLikeProducts()
        setupOnClickListener()
    }

    private fun setupOnClickListener() {
        binding.btnAddToCart.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_view_cart)
        }
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
        val adapter = ProductInfoPagerAdapter(childFragmentManager)

        adapter.addFragment(DescriptionFragment(), getString(R.string.title_description))
        adapter.addFragment(
            AdditionalInformationFragment(),
            getString(R.string.title_additional_info)
        )
        adapter.addFragment(ShippingReturnFragment(), getString(R.string.title_shipping_returns))

        binding.vpProductInfo.adapter = adapter
        binding.tabLay.setupWithViewPager(binding.vpProductInfo)

        binding.vpProductInfo.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(binding.tabLay)
        )
    }

    private fun setupAlsoLikeProducts() {
        binding.rvAlsoLike.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding.rvAlsoLike.adapter = ProductsAdapter(requireActivity())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}