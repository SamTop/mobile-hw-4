package com.example.homework4

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.homework4.viewModel.CitiesViewModel
import com.example.homework4.viewModel.ScreenSettingsViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


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

//    @Before
//    fun setup() {
//        val validCityName = "Yerevan"
//        val invalidCityName = "asdfasdfasdfasdfasdfasdf"
//        validViewModel = CitiesViewModel(validCityName)
//        invalidViewModel = CitiesViewModel(invalidCityName)
//
//        val mockBookService = Mockito.mock(BookService::class.java)
//        Mockito.`when`(mockBookService. inStock(100)).thenReturn(true)
//    }
//
//    @Test
//    fun conversionIsCorrectC2C() {
//        viewModel.setTemperatureUnit(TemperatureUnit.CELSIUS)
//        assertEquals(1.0, viewModel.convertTemperature(1.0), 0.00001)
//        assertEquals(2.0, viewModel.convertTemperature(2.0), 0.00001)
//        assertEquals(3.0, viewModel.convertTemperature(3.0), 0.00001)
//        assertEquals(4.0, viewModel.convertTemperature(4.0), 0.00001)
//        assertEquals(5.0, viewModel.convertTemperature(5.0), 0.00001)
//        assertEquals(true, true)
//    }
}
