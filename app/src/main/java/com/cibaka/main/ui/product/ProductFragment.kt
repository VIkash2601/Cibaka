package com.cibaka.main.ui.product

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cibaka.databinding.FragmentProductBinding
import com.cibaka.main.ui.product.adapter.ProductsAdapter

class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null

    private val binding get() = _binding!!
    private var mActivity: Activity? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init() {
        mActivity = requireActivity()
        setupProducts()
    }

    private fun setupProducts() {
        binding.rvProducts.layoutManager =
            GridLayoutManager(mActivity!!, 2, LinearLayoutManager.VERTICAL, false)
        binding.rvProducts.adapter = ProductsAdapter(mActivity!!)
    }
}