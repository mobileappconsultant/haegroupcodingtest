package com.haehome

import com.haehome.di.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher

@OptIn(ExperimentalCoroutinesApi::class)
class TestDispatcherProvider(
    override val io: CoroutineDispatcher = UnconfinedTestDispatcher(),
    override val main: CoroutineDispatcher = StandardTestDispatcher()
) : DispatcherProvider
