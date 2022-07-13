package com.haehome.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

public interface DispatcherProvider {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
}

class DispatcherProviderImpl(
    override val io: CoroutineDispatcher = Dispatchers.IO,
    override val main: CoroutineDispatcher = Dispatchers.Main
) : DispatcherProvider
