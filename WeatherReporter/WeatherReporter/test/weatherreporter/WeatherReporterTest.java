package weatherreporter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class WeatherReporterTest {
    WeatherReporter weatherReporter;

    @Test
    public void canary() {
        assertTrue(true);
    }

    @Before
    public void setup() {
        weatherReporter = new WeatherReporter();
    }

    @Test
    public void checkSortingByCityNameForAlreadySortedList() {

        List<CityInformation> citiesInformation = Arrays.asList(
                new CityInformation("Dallas", "TX", 77090),
                new CityInformation("Houston", "TX", 77025),
                new CityInformation("San Fransisco", "CA", 94102));

        List<CityInformation> result = weatherReporter.sortByCityName(citiesInformation);

        assertEquals("Dallas", result.get(0).getCityName());
        assertEquals("Houston", result.get(1).getCityName());
        assertEquals("San Fransisco", result.get(2).getCityName());
    }

    @Test
    public void checkSortingByCityNameForSecondCityInFirstPlace() {

        List<CityInformation> citiesInformation = Arrays.asList(
                new CityInformation("Houston", "TX", 77025),
                new CityInformation("Dallas", "TX", 77090),
                new CityInformation("San Fransisco", "CA", 94102));

        List<CityInformation> result = weatherReporter.sortByCityName(citiesInformation);

        assertEquals("Dallas", result.get(0).getCityName());
        assertEquals("Houston", result.get(1).getCityName());
        assertEquals("San Fransisco", result.get(2).getCityName());
    }

    @Test
    public void checkSortingByCityNameForLastCityInFirstPlace() {

        List<CityInformation> citiesInformation = Arrays.asList(
                new CityInformation("San Fransisco", "CA", 94102),
                new CityInformation("Houston", "TX", 77025),
                new CityInformation("Dallas", "TX", 77090));

        List<CityInformation> result = weatherReporter.sortByCityName(citiesInformation);

        assertEquals("Dallas", result.get(0).getCityName());
        assertEquals("Houston", result.get(1).getCityName());
        assertEquals("San Fransisco", result.get(2).getCityName());
    }

    @Test
    public void checkSortingByCityNameIfNoCityIsPassed() {

        List<CityInformation> citiesInformation = Arrays.asList();

        List<CityInformation> result = weatherReporter.sortByCityName(citiesInformation);

        assertEquals(0, result.size());
    }

    @Test
    public void findWarmestCityFromListIfAllCitiesPresent() {

        List<CityInformation> citiesInformation = Arrays.asList(
                new CityInformation(94102, "San Fransisco", "CA", 5, 87, "Cold"),
                new CityInformation(77025, "Houston", "TX", 9, 56, "Cold"),
                new CityInformation(77090, "Dallas", "TX", 8, 67, "Cold"));

        List<CityInformation> result = weatherReporter.findWarmestCities(citiesInformation);

        assertEquals("San Fransisco", result.get(0).getCityName());
    }

    @Test
    public void findWarmestCityIfThereAreNoCities() {

        List<CityInformation> citiesInformation = Arrays.asList();

        List<CityInformation> result = weatherReporter.findWarmestCities(citiesInformation);

        assertEquals(0, result.size());
    }

    @Test
    public void warmestCityIfTwoCitiesHaveSameMaxTemp() {

        List<CityInformation> citiesInformation = Arrays.asList(
                new CityInformation(77090, "Dallas", "TX", 5, 87, "Cold"),
                new CityInformation(94107, "San Francisco", "CA", 9, 56, "Cold"),
                new CityInformation(770258, "Houston", "TX", 5, 87, "Cold"));

        List<CityInformation> result = weatherReporter.findWarmestCities(citiesInformation);

        assertEquals(2, result.size());
        assertEquals("Dallas", result.get(0).getCityName());
        assertEquals("Houston", result.get(1).getCityName());
    }

    @Test
    public void findColdestCityFromListIfAllCitiesPresent() {

        List<CityInformation> citiesInformation = Arrays.asList(
                new CityInformation(94102, "San Fransisco", "CA", 5, 87, "Cold"),
                new CityInformation(77025, "Houston", "TX", 9, 56, "Cold"),
                new CityInformation(77090, "Dallas", "TX", 8, 67, "Cold"));


        List<CityInformation> result = weatherReporter.findColdestCities(citiesInformation);

        assertEquals("San Fransisco", result.get(0).getCityName());
    }

    @Test
    public void findColdestCityFromListIfAllCitiesAreNull() {

        List<CityInformation> citiesInformation = Arrays.asList();

        List<CityInformation> result = weatherReporter.findColdestCities(citiesInformation);

        assertEquals(0, result.size());
    }

    @Test
    public void coldestCityIfTwoCitiesHaveSameMinTemp() {

        List<CityInformation> citiesInformation = Arrays.asList(
                new CityInformation(77090, "Dallas", "TX", 5, 87, "Cold"),
                new CityInformation(94107, "San Francisco", "CA", 9, 56, "Cold"),
                new CityInformation(770258, "Houston", "TX", 5, 87, "Cold"));

        List<CityInformation> result = weatherReporter.findColdestCities(citiesInformation);

        assertEquals(2, result.size());
        assertEquals("Dallas", result.get(0).getCityName());
        assertEquals("Houston", result.get(1).getCityName());
    }

    @Test
    public void getZipCodeInformationFromLocationService() {

        List<CityInformation> cityInformation = Arrays.asList(new CityInformation("Houston", "TX", 77054));

        LocationService mockLocationService = mock(LocationService.class);
        when(mockLocationService.getCityAndState("77054")).thenReturn(new CityInformation("Houston", "TX", 77054));
        weatherReporter.setLocationService(mockLocationService);

        List<CityInformation> result = weatherReporter.getCitiesInformation(Arrays.asList("77054"));

        assertEquals(cityInformation.get(0).getCityName(), result.get(0).getCityName());
    }

    @Test
    public void getZipCodeInformationFromLocationServiceReturnsNoResult() {

        List<CityInformation> result = weatherReporter.getCitiesInformation(Arrays.asList());

        assertEquals(0, result.size());
    }

    @Test
    public void getZipCodeInformationFromLocationServiceFor3ZipCodesReturns3Results() {

        List<CityInformation> citiesInformation = Arrays.asList(
                new CityInformation(77090, "Dallas", "TX", 5, 87, "Cold"),
                new CityInformation(94107, "San Francisco", "CA", 9, 56, "Cold"),
                new CityInformation(77054, "Houston", "TX", 5, 87, "Cold"));

        LocationService mockLocationService = mock(LocationService.class);
        when(mockLocationService.getCityAndState("77090")).thenReturn(new CityInformation("Dallas", "TX", 77090));
        when(mockLocationService.getCityAndState("94107")).thenReturn(new CityInformation("San Francisco", "CA", 94107));
        when(mockLocationService.getCityAndState("77054")).thenReturn(new CityInformation("Houston", "TX", 77054));
        weatherReporter.setLocationService(mockLocationService);

        List<CityInformation> result = weatherReporter.getCitiesInformation(Arrays.asList("77090", "94107", "77054"));

        assertEquals(citiesInformation.get(0).getCityName(), result.get(0).getCityName());
        assertEquals(citiesInformation.get(1).getCityName(), result.get(1).getCityName());
        assertEquals(citiesInformation.get(2).getCityName(), result.get(2).getCityName());
    }

    @Test
    public void getThreeZipCodeWith2ValidAndOneInvalidCheckForDetailsOfAll() {
        List<CityInformation> citiesInformation = Arrays.asList(
                new CityInformation(77090, "Dallas", "TX", 5, 87, "Cold"),
                new CityInformation(94107, "San Francisco", "CA", 9, 56, "Cold"),
                new CityInformation());

        LocationService mockLocationService = mock(LocationService.class);
        when(mockLocationService.getCityAndState("77090")).thenReturn(new CityInformation("Dallas", "TX", 77090));
        when(mockLocationService.getCityAndState("94107")).thenReturn(new CityInformation("San Francisco", "CA", 94107));
        when(mockLocationService.getCityAndState("7705456")).thenReturn(new CityInformation());
        weatherReporter.setLocationService(mockLocationService);

        List<CityInformation> result = weatherReporter.getCitiesInformation(Arrays.asList("77090", "94107", "7705456"));

        assertEquals(2, result.size());
        assertEquals(citiesInformation.get(0).getCityName(), result.get(0).getCityName());
        assertEquals(citiesInformation.get(1).getCityName(), result.get(1).getCityName());
    }

    @Test
    public void getWeatherInformationFromWeatherServiceForOneCity() {

        List<CityInformation> cityInformation = Arrays.asList(new CityInformation(5, 87, "Cold", 77090));

        WeatherService mockWeatherService = mock(WeatherService.class);
        when(mockWeatherService.getWeather("77090")).thenReturn(new CityInformation(5, 87, "Cold", 77090));
        weatherReporter.setWeatherService(mockWeatherService);

        List<CityInformation> result = weatherReporter.getCitiesInformation(Arrays.asList("77090"));

        assertEquals(cityInformation.get(0).getMinTemperature(), result.get(0).getMinTemperature());
    }

    @Test
    public void getWeatherInformationFromWeatherServiceForOneCityReturnsNoValues() {

        WeatherService mockWeatherService = mock(WeatherService.class);
        when(mockWeatherService.getWeather("77090")).thenReturn(new CityInformation());
        weatherReporter.setWeatherService(mockWeatherService);

        List<CityInformation> result = weatherReporter.getCitiesInformation(Arrays.asList("77090"));

        assertEquals(0, result.size());
    }

    @Test
    public void getInforamtionForLocationAndWeatherForOneCityTogether() {

        WeatherService mockWeatherService = mock(WeatherService.class);
        LocationService mockLocationService = mock(LocationService.class);
        when(mockWeatherService.getWeather("77090")).thenReturn(new CityInformation("Dallas", "TX", 77090));
        when(mockLocationService.getCityAndState("77090")).thenReturn(new CityInformation(10, 20, "cool", 77090));

        weatherReporter.setWeatherService(mockWeatherService);
        weatherReporter.setLocationService(mockLocationService);

        List<CityInformation> result = weatherReporter.getCitiesInformation(Arrays.asList("77090"));

        assertEquals(1, result.size());
        assertEquals("Dallas", result.get(0).getCityName());
        assertEquals("TX", result.get(0).getStateName());
        assertEquals(10, result.get(0).getMinTemperature());
        assertEquals(20, result.get(0).getMaxTemperature());
        assertEquals("cool", result.get(0).getForecast24h());
    }
}
