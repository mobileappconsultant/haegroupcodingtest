package com.haehome.data.network

sealed class NetworkResult<out T: Any> {
    data class Success<out T: Any>(val data : T) : NetworkResult<T>()
    data class Failure(val message: String, val cause: Exception? = null): NetworkResult<Nothing>()
}
