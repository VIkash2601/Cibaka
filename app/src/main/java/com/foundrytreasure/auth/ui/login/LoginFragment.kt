package com.foundrytreasure.auth.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.foundrytreasure.R
import com.foundrytreasure.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val loginViewModel =
            ViewModelProvider(this)[LoginViewModel::class.java]

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }

    private fun init() {
        binding.tvRegister.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_from_login_to_register)
        }
        binding.btnLogin.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_from_login_to_main_activity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}