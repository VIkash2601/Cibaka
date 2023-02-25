package com.cibaka.main.ui.sub_category

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cibaka.databinding.FragmentSubCategoryBinding
import com.cibaka.main.ui.sub_category.adapter.SubCategoryAdapter

class SubCategoryFragment : Fragment() {

    private var _binding: FragmentSubCategoryBinding? = null

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
            ViewModelProvider(this).get(SubCategoryViewModel::class.java)

        _binding = FragmentSubCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }

    private fun init() {
        mActivity = requireActivity()
        setupSubCategories()
    }

    private fun setupSubCategories() {
        binding.rvSubCategories.layoutManager =
            GridLayoutManager(mActivity!!, 2, LinearLayoutManager.VERTICAL, false)
        binding.rvSubCategories.adapter = SubCategoryAdapter(mActivity!!)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}