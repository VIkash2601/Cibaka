package com.foundrytreasure.auth.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.foundrytreasure.R
import com.foundrytreasure.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val registerViewModel =
            ViewModelProvider(this)[RegisterViewModel::class.java]

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }

    private fun init() {
        binding.tvLogin.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_from_register_to_login)
        }
        binding.btnRegister.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_from_register_to_main_activity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}