package com.example.homework4

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.homework4.repository.Current
import com.example.homework4.repository.DataLoaderRepository
import com.example.homework4.repository.WeatherResponse
import com.example.homework4.viewModel.CitiesViewModel
import com.example.homework4.viewModel.ScreenSettingsViewModel
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.eq
import org.mockito.quality.Strictness
import retrofit2.HttpException


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class CitiesViewModelTest {
    @JvmField
    @Rule
    var executorRule = InstantTaskExecutorRule()


    private lateinit var validViewModel: CitiesViewModel
    private lateinit var invalidViewModel: CitiesViewModel

    private lateinit var mockedRepo: DataLoaderRepository

    val validCityName = "Yerevan"
    val invalidCityName = "asdfasdfasdfasdfasdfasdf"
    val testKey = "835accff432e440da92113836231211"

    @Before
    fun setup() = runBlocking {
        mockedRepo = Mockito.mock(DataLoaderRepository::class.java)
        Mockito.lenient().`when`(mockedRepo. loadWeather(validCityName, testKey)).thenReturn(
            WeatherResponse(Current(12.0, 34.0)))
        Mockito.lenient().`when`(mockedRepo. loadWeather(invalidCityName, testKey)).thenReturn(
            WeatherResponse(Current(1234.0, 1234.0))
        )

        val testDispatcher = Dispatchers.Unconfined
        validViewModel = CitiesViewModel(validCityName, mockedRepo, testDispatcher)
        invalidViewModel = CitiesViewModel(invalidCityName, mockedRepo, testDispatcher)
    }

    @Test
    fun correctForValidCity() {
        validViewModel.weather.value?.current?.let { assertEquals(it.temperatureCelsius, 12.0, 0.1) }
    }

    @Test
    fun incorrectForValidCity() {
        invalidViewModel.weather.value?.current?.let { assertEquals(1234.0, it.temperatureCelsius, 0.1) }
        invalidViewModel.weather.value?.current?.let { assertEquals(1234.0, it.temperatureFahrenheit, 0.1) }
    }

}
