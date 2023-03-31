package com.cibaka.main.ui.notifications

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cibaka.databinding.FragmentNotificationsBinding
import com.cibaka.main.ui.notifications.adapter.NotificationsAdapter

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var mActivity: Activity? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }

    private fun init() {
        mActivity = requireActivity()
        setupNotifications()
    }

    private fun setupNotifications() {
        binding.rvNotifications.layoutManager =
            LinearLayoutManager(mActivity!!, LinearLayoutManager.VERTICAL, false)
        binding.rvNotifications.adapter = NotificationsAdapter(mActivity!!)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}