package com.haehome.viewmodel

import com.haehome.TestDispatcherProvider
import com.haehome.data.model.WeatherInfo
import com.haehome.ui.viewModel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private val repository = FakeWeatherRepository()
    private val dispatcherProvider = TestDispatcherProvider()
    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        viewModel = MainViewModel(repository, dispatcherProvider)
    }

    @Test
    fun `given when mainViewModel getWeatherDetails is called and result is successful, the right data should be emitted`() = runTest {
        viewModel.getWeatherDetails()
        val uiStates = mutableListOf<MainViewModel.WeatherState?>()
        viewModel.weatherState.take(2).toList(uiStates)

        val expected = MainViewModel.WeatherState.Success(WeatherInfo(
            city = "Copahaegan",
            country = "Norway",
            temp = 12.0,
            description = "Mild cold and breezy"
        ))
        Assert.assertEquals(expected , viewModel.weatherState.value)
    }

    @Test
    fun `given when mainViewModel getWeatherDetails is called and result is not successful, the right data should be emitted`() = runTest {
        repository.simulateFailure = true
        viewModel.getWeatherDetails()
        val uiStates = mutableListOf<MainViewModel.WeatherState?>()
        viewModel.weatherState.take(2).toList(uiStates)

        val expected = MainViewModel.WeatherState.Failure(message = "An error occurred")
        Assert.assertEquals(expected , viewModel.weatherState.value)
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

}