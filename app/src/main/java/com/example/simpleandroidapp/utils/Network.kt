package com.example.simpleandroidapp.utils

import java.io.IOException

/**
 * Helper function for doing asynchronous network calls.
 */
suspend fun <T : Any> apiCall(call: suspend () -> Result<T>, errorMessage: String): Result<T> {
    return try {
        call()
    } catch (e: Exception) {
        Result.failure(IOException(errorMessage, e))
    }
}