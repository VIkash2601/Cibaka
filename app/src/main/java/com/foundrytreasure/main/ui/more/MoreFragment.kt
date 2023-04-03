package com.foundrytreasure.main.ui.more

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.foundrytreasure.R
import com.foundrytreasure.auth.AuthenticationActivity
import com.foundrytreasure.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var mActivity: Activity? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val moreViewModel =
            ViewModelProvider(this)[MoreViewModel::class.java]

        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }

    private fun init() {
        mActivity = requireActivity()
        setupOnClickListener()
    }

    private fun setupOnClickListener() {
        binding.clLogout.setOnClickListener {
            mActivity!!.startActivity(Intent(mActivity!!, AuthenticationActivity::class.java))
            mActivity!!.finishAffinity()
        }

        binding.clOrders.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_go_to_my_orders)
        }

        binding.clNotifications.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_go_to_notifications)
        }

        binding.clProfile.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_go_to_profile)
        }

        binding.clAboutUs.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_go_to_about_us)
        }

        binding.clContactUs.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_go_to_contact_us)
        }

        binding.clPrivacyPolicy.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_go_to_privacy_policy)
        }

        binding.clRefundPolicy.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_go_to_refund_policy)
        }

        binding.clTermsConditions.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_go_to_terms_conditions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}