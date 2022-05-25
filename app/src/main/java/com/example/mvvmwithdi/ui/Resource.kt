package com.example.mvvmwithdi.ui


sealed class Resource<T>(
    val data: T? = null,
    val endpoint: String? = null,
    val message: String? = null,
) {

    class Success<T>(data: T?, endpoint: String?) : Resource<T>(data, endpoint)
    class Error<T>(message: String?) : Resource<T>(message = message)
    class Loading<T> : Resource<T>()

}
