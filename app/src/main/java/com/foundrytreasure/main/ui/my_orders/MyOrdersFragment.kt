package com.foundrytreasure.main.ui.my_orders

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.foundrytreasure.databinding.FragmentMyOrdersBinding
import com.foundrytreasure.main.ui.my_orders.adapter.OrdersAdapter

class MyOrdersFragment : Fragment() {

    private var _binding: FragmentMyOrdersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var mActivity: Activity? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMyOrdersBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }

    private fun init() {
        mActivity = requireActivity()
        setupOrders()
    }

    private fun setupOrders() {
        binding.rvOrders.layoutManager =
            LinearLayoutManager(mActivity!!, LinearLayoutManager.VERTICAL, false)
        binding.rvOrders.adapter = OrdersAdapter(mActivity!!)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}