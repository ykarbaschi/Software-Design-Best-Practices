package weatherreporter;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherWebServiceTest {
    WeatherWebService weatherWebService;

    @Before
    public void setUp() {
        weatherWebService = new WeatherWebService();
    }

    @Test
    public void getWeatherDataForOneValidZipCode() {
        CityInformation result = weatherWebService.getWeather("77054");

        assertEquals(true, result.getCityName() == null);
        assertEquals(false, result.getForecast24h() == null);
        assertEquals("Valid", result.getStatusWeather());
    }

    @Test
    public void getDetailsForOneInvalidZipCode() {
        CityInformation result = weatherWebService.getWeather("sfdfds3123");

        assertEquals(true, result.getForecast24h() == null);
        assertEquals("Invalid", result.getStatusWeather());
    }

    @Test
    public void getDetailsForOneValidZipCodeButNotInUS() {
        CityInformation result = weatherWebService.getWeather("88090");

        assertEquals("Invalid", result.getStatusWeather());
    }

    @Test
    public void serviceIsNotAvailable() throws Exception {
        WeatherWebService mockWeatherService = mock(WeatherWebService.class);
        when(mockWeatherService.connectToWeatherService(any())).thenThrow(new IOException());
        when(mockWeatherService.getWeather(any())).thenCallRealMethod();

        try{
            mockWeatherService.getWeather("65656");
        }catch (Exception e){}
    }

    @Test
    public void ifWeatherServiceIsAvailableButReturnEmptyString() throws Exception{
        WeatherWebService mockWeatherService = mock(WeatherWebService.class);
        when(mockWeatherService.connectToWeatherService(any())).thenReturn("");
        when(mockWeatherService.getWeather(any())).thenCallRealMethod();

        CityInformation result = mockWeatherService.getWeather("56767");
        assertEquals("Invalid", result.getStatusWeather());
    }

   /* @Test
    public void checkingForExceptionInJsonObject(){
        WeatherWebService mockWeatherService = mock(WeatherWebService.class);
        when(mockWeatherService.getWeather("99999")).thenReturn("");

        CityInformation result = weatherWebService.getWeather("99999");
    }*/
}
