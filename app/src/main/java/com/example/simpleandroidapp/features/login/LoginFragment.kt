package com.example.simpleandroidapp.features.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.simpleandroidapp.MainActivity
import com.example.simpleandroidapp.R
import com.example.simpleandroidapp.databinding.FragmentLoginBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * Fragment responsible for the login of the app
 */
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val model: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtonClickListeners()
        setObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setButtonClickListeners() {
        binding.forgotPasswordButton.setOnClickListener {
            Toast.makeText(activity, R.string.password_hint, Toast.LENGTH_SHORT).show()
        }

        binding.loginButton.setOnClickListener {
            model.performLogin(
                username = binding.usernameEditText.text.toString(),
                password = binding.passwordEditText.text.toString()
            )
        }
    }

    private fun setObservers() {
        model.loginValidation.observe(viewLifecycleOwner) { viewState ->
            when (viewState) {
                is LoginViewModel.ViewState.NoUsername -> {
                    Log.e("Error", "No username entered")
                    createDialog(R.string.error_no_username)
                }
                is LoginViewModel.ViewState.WrongPassword -> {
                    Log.e("Error", "Wrong password entered")
                    createDialog(R.string.error_wrong_password)
                }
                is LoginViewModel.ViewState.SuccessfulLogin -> {
                    Log.i("Success", "Correct login with user: ${viewState.username}")
                    (activity as MainActivity).goToDetailsFragment(viewState.username)
                }
            }
        }
    }

    private fun createDialog(messageId: Int) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.error_title)
            .setMessage(messageId)
            .setPositiveButton(R.string.error_positive_action) { dialog, _ ->
                dialog.cancel()
            }
            .show()
    }
}