package com.example.simpleandroidapp.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.simpleandroidapp.MainActivity
import com.example.simpleandroidapp.R
import com.example.simpleandroidapp.databinding.FragmentDetailsBinding
import com.example.simpleandroidapp.utils.Constants
import com.giphy.sdk.ui.Giphy
import com.giphy.sdk.ui.pagination.GPHContent

class DetailsFragment: Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val model: DetailsViewModel by viewModels()
    private var args: Bundle? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater)

        args = arguments

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUsernameData()
        setButtonClickListeners()
        //setupObservers()
    }

    private fun setButtonClickListeners() {
        binding.logoutButton.setOnClickListener {
            (activity as MainActivity).goToLoginFragment()
        }
    }

    private fun bindUsernameData() {
        val username = args?.get((activity as MainActivity).USERNAME_KEY)
        val welcomeText = getString(R.string.welcome, username)
        binding.welcomeText.text = welcomeText
    }

    private fun initGiphy() {

    }

    private fun setupObservers() {
        TODO("Implement")
    }

    private fun bindGifData() {
        TODO("Bind the gif data and metadata here")
    }

}