package com.foundrytreasure.main.ui.checkout

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.foundrytreasure.databinding.FragmentCheckoutBinding
import com.foundrytreasure.main.ui.cart.interfaces.OnCartItemAddedListener
import com.foundrytreasure.main.ui.cart.interfaces.OnCartItemRemovedListener

class CheckoutFragment : Fragment(), OnCartItemAddedListener, OnCartItemRemovedListener {

    private var _binding: FragmentCheckoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var mActivity: Activity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }

    private fun init() {
        mActivity = requireActivity()
        setupOnClickListener()
    }

    private fun setupOnClickListener() {
        /*binding.btnProceedToPay.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_checkout)
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCartAddedClicked(itemId: Int) {

    }

    override fun onCartRemovedClicked(itemId: Int) {

    }
}