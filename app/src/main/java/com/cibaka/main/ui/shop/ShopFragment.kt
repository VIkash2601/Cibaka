package com.cibaka.main.ui.shop

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cibaka.databinding.FragmentShopBinding
import com.cibaka.main.ui.home.adapter.HomeCategoryAdapter

class ShopFragment : Fragment() {

    private var _binding: FragmentShopBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var mActivity: Activity? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(ShopViewModel::class.java)

        _binding = FragmentShopBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }

    private fun init() {
        mActivity = requireActivity()
        setupCategories()
    }

    private fun setupCategories() {
        binding.rvCategories.layoutManager =
            GridLayoutManager(mActivity!!, 2, LinearLayoutManager.VERTICAL, false)
        binding.rvCategories.adapter = HomeCategoryAdapter(mActivity!!)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}