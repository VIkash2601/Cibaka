package com.foundrytreasure.main.ui.contact_us

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.foundrytreasure.databinding.FragmentContactUsBinding

class ContactUsFragment : Fragment() {

    private var _binding: FragmentContactUsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var mActivity: Activity? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentContactUsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }

    private fun init() {
        mActivity = requireActivity()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}