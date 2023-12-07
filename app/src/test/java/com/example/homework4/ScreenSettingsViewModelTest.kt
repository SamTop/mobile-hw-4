package com.example.homework4

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.homework4.viewModel.ScreenSettingsViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class ScreenSettingsViewModelUnitTest {

//    companion object {
//        init {
//            // things that may need to be setup before companion class member variables are instantiated
//            viewModel = ScreenSettingsViewModel()
//        }
//
//        // variables you initialize for the class just once:
//        val vm = ScreenSettingsViewModel()
//
//        // variables you initialize for the class later in the @BeforeClass method:
////        lateinit var vm: ScreenSettingsViewModel
//
//        @BeforeClass
//        @JvmStatic fun setup() {
//            // things to execute once and keep around for the class
//        }
//
//        @AfterClass
//        @JvmStatic fun teardown() {
//            // clean up after this class, leave nothing dirty behind
//        }
//    }

    @JvmField
    @Rule
    var executorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ScreenSettingsViewModel

    @Before
    fun setup() {
        viewModel = ScreenSettingsViewModel()
    }

    @Test
    fun conversionIsCorrectC2C() {
        viewModel.setTemperatureUnit(TemperatureUnit.CELSIUS)
        assertEquals(1.0, viewModel.convertTemperature(1.0), 0.00001)
        assertEquals(2.0, viewModel.convertTemperature(2.0), 0.00001)
        assertEquals(3.0, viewModel.convertTemperature(3.0), 0.00001)
        assertEquals(4.0, viewModel.convertTemperature(4.0), 0.00001)
        assertEquals(5.0, viewModel.convertTemperature(5.0), 0.00001)
        assertEquals(true, true)
    }

    @Test
    fun conversionIsCorrectC2F() {
        viewModel.setTemperatureUnit(TemperatureUnit.FAHRENHEIT)
        assertEquals(33.8, viewModel.convertTemperature(1.0), 0.00001)
        assertEquals(35.6, viewModel.convertTemperature(2.0), 0.00001)
        assertEquals(37.4, viewModel.convertTemperature(3.0), 0.00001)
        assertEquals(39.2, viewModel.convertTemperature(4.0), 0.00001)
        assertEquals(41.0, viewModel.convertTemperature(5.0), 0.00001)
        assertEquals(true, true)
    }

    @Test
    fun tempUnitIsSetCorrectly() {
        val data = arrayListOf(TemperatureUnit.FAHRENHEIT, TemperatureUnit.CELSIUS)

        for (unit in data) {
            viewModel.setTemperatureUnit(unit)
            assertEquals(unit, viewModel.unit.value)
        }
    }
}
