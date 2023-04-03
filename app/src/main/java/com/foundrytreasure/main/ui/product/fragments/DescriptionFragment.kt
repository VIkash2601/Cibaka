package com.foundrytreasure.main.ui.product.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.foundrytreasure.databinding.FragmentDescriptionBinding

class DescriptionFragment : Fragment() {

    private var _binding: FragmentDescriptionBinding? = null
    private val binding get() = _binding!!

    private var mActivity: Activity? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        mActivity = requireActivity()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}