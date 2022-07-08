package com.example.simpleandroidapp.features.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleandroidapp.api.GiphyDataSource
import com.example.simpleandroidapp.models.GiphyData
import kotlinx.coroutines.launch

/**
 * ViewModel for the details view, responsible for calling for network requests.
 */
class DetailsViewModel : ViewModel() {
    private val giphyDataSource = GiphyDataSource()

    private val _gifFetching = MutableLiveData<ViewState>()
    val gifFetching: LiveData<ViewState> = _gifFetching

    fun fetchData() {
        _gifFetching.value = ViewState.Loading
        viewModelScope.launch {
            try {
                val giphyDataResponse = giphyDataSource.getTrendingGifs()

                if (giphyDataResponse.isSuccess) {
                    _gifFetching.value = ViewState.LoadingSuccessful(
                        giphyDataResponse.getOrNull()
                    )
                } else {
                    _gifFetching.value = ViewState.LoadingFailure(
                        "Error loading gifs"
                    )
                }
            } catch (e: Exception) {
                _gifFetching.value = ViewState.LoadingFailure(
                    "Error loading gifs"
                )
            }
        }
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class LoadingSuccessful(
            val giphyData: GiphyData?
        ) : ViewState()

        data class LoadingFailure(
            val errorMessage: String? = null
        ) : ViewState()
    }
}