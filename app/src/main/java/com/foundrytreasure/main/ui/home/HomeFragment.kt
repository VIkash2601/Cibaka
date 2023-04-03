package com.foundrytreasure.main.ui.home

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.foundrytreasure.R
import com.foundrytreasure.databinding.FragmentHomeBinding
import com.foundrytreasure.main.ui.home.adapter.HomeCategoryAdapter
import com.foundrytreasure.main.ui.home.adapter.HomeSliderAdapter
import com.foundrytreasure.main.ui.home.adapter.HomeTrendingProductAdapter

class HomeFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null

    private var mActivity: Activity? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }

    private fun init() {
        mActivity = requireActivity()
        setUpHomeSlider()
        setupCategories()
        setupTrendingProducts()
        setupOnClickListener()
    }

    private fun setupOnClickListener() {
        binding.ivCart.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_view_cart)
        }
        binding.ivNotifications.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_go_to_notifications)
        }
    }

    private fun setUpHomeSlider() {
        binding.autoScrollViewpager.adapter = HomeSliderAdapter(mActivity!!)
        binding.autoScrollViewpager.clipToPadding = false
        binding.autoScrollViewpager.setPadding(100, 0, 100, 0)
        binding.autoScrollViewpager.pageMargin = 50
        binding.autoScrollViewpager.offscreenPageLimit = 5
        binding.viewPagerDots.attachTo(binding.autoScrollViewpager)
        binding.autoScrollViewpager.startAutoScroll()
    }

    private fun setupCategories() {
        binding.rvCategories.layoutManager =
            GridLayoutManager(mActivity!!, 2, LinearLayoutManager.VERTICAL, false)
        binding.rvCategories.adapter = HomeCategoryAdapter(mActivity!!)
    }

    private fun setupTrendingProducts() {
        binding.rvTrendingProducts.layoutManager =
            LinearLayoutManager(mActivity!!, LinearLayoutManager.VERTICAL, false)
        binding.rvTrendingProducts.adapter = HomeTrendingProductAdapter(mActivity!!)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {

    }
}