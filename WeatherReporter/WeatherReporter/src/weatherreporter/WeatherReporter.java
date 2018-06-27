package weatherreporter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.toList;

public class WeatherReporter {

    private LocationService locationService;
    private WeatherService weatherService;

    public void setLocationService(LocationService service) {
        locationService = service;
    }

    public void setWeatherService(WeatherService service) {
        weatherService = service;
    }

    public List<CityInformation> sortByCityName(List<CityInformation> listOfCities) {
        return
                listOfCities.stream()
                            .sorted(comparing(CityInformation::getCityName))
                            .collect(toList());
    }

    public List<CityInformation> findWarmestCities(List<CityInformation> citiesInformation) {

        int maxTemperature =
                citiesInformation.stream()
                                 .mapToInt(CityInformation::getMaxTemperature)
                                 .max()
                                 .orElse(0);

        return citiesInformation.stream()
                                .filter(cityInfo -> cityInfo.getMaxTemperature() == maxTemperature)
                                .collect(toList());
    }

    public List<CityInformation> findColdestCities(List<CityInformation> citiesInformation) {
        int minTemperature =
                citiesInformation.stream()
                                 .mapToInt(CityInformation::getMinTemperature)
                                 .min()
                                 .orElse(0);

        return citiesInformation.stream()
                                .filter(cityInfo -> cityInfo.getMinTemperature() == minTemperature)
                                .collect(toList());
    }

    public List<CityInformation> getCitiesInformation(List<String> zipCodes) {
        List<CityInformation> result = new ArrayList<>();
        CityInformation dataOnlyForLocation = new CityInformation();
        CityInformation dataOnlyForWeather = new CityInformation();

        if (zipCodes.size() != 0) {
            for (String zipCode : zipCodes) {
                if (locationService != null) {
                    dataOnlyForLocation = locationService.getCityAndState(zipCode);
                }
                if (weatherService != null) {
                    dataOnlyForWeather = weatherService.getWeather(zipCode);
                }
                CityInformation combinedData = new CityInformation();
                combinedData.combine(dataOnlyForLocation);
                combinedData.combine(dataOnlyForWeather);

                if (combinedData.getStatusLocation().equals("Valid") || combinedData.getStatusWeather().equals("Valid")) {
                    result.add(combinedData);
                }
            }
        }
        return result;
    }
}