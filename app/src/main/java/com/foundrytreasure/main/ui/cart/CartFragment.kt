package com.foundrytreasure.main.ui.cart

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.foundrytreasure.R
import com.foundrytreasure.databinding.FragmentCartBinding
import com.foundrytreasure.main.ui.cart.adapter.CartItemAdapter
import com.foundrytreasure.main.ui.cart.interfaces.OnCartItemAddedListener
import com.foundrytreasure.main.ui.cart.interfaces.OnCartItemRemovedListener

class CartFragment : Fragment(), OnCartItemAddedListener, OnCartItemRemovedListener {

    private var _binding: FragmentCartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var mActivity: Activity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]

        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }

    private fun init() {
        mActivity = requireActivity()
        setupOnClickListener()
        binding.rvCartItems.layoutManager =
            LinearLayoutManager(mActivity!!, LinearLayoutManager.VERTICAL, false)
        binding.rvCartItems.adapter =
            CartItemAdapter(mActivity!!, this@CartFragment, this@CartFragment)
    }

    private fun setupOnClickListener() {
        binding.btnProceedToPay.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_checkout)
        }
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