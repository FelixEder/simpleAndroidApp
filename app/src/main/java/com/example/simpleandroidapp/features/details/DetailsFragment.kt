package com.example.simpleandroidapp.features.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.simpleandroidapp.MainActivity
import com.example.simpleandroidapp.R
import com.example.simpleandroidapp.databinding.FragmentDetailsBinding
import com.example.simpleandroidapp.models.GiphyData

/**
 * Fragment responsible for showing the main page of the app, the details screen!
 */
class DetailsFragment : Fragment() {
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
        setupObservers()
        model.fetchData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setButtonClickListeners() {
        binding.logoutButton.setOnClickListener {
            (activity as MainActivity).goToLoginFragment()
        }
    }

    private fun bindUsernameData() {
        val username = args?.get(MainActivity.USERNAME_KEY)
        val welcomeText = getString(R.string.welcome, username)
        binding.welcomeText.text = welcomeText
    }

    private fun setupObservers() {
        model.gifFetching.observe(viewLifecycleOwner) { viewState ->
            when (viewState) {
                is DetailsViewModel.ViewState.Loading -> {
                    toggleLoadingSpinner(true)
                }

                is DetailsViewModel.ViewState.LoadingSuccessful -> {
                    toggleLoadingSpinner(false)
                    if (viewState.giphyData != null)
                        bindGifData(viewState.giphyData)
                }

                is DetailsViewModel.ViewState.LoadingFailure -> {
                    toggleLoadingSpinner(false)
                    Toast.makeText(activity, R.string.gif_error, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun toggleLoadingSpinner(toggleOn: Boolean) {
        if (toggleOn)
            binding.loadingSpinner.visibility = View.VISIBLE
        else
            binding.loadingSpinner.visibility = View.INVISIBLE
    }

    private fun bindGifData(giphyData: GiphyData) {
        giphyData.data?.firstOrNull().let {
            val metaText = getString(R.string.gif_meta, it?.title, it?.username)
            binding.gifMetaText.text = metaText

            val gifUrl = it?.images?.original?.url

            Glide.with(this)
                .asGif()
                .placeholder(R.drawable.image_placeholder)
                .load(gifUrl)
                .into(binding.gifImage)
        }
    }
}