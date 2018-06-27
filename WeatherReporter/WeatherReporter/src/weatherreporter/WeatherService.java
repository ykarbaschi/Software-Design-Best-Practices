package weatherreporter;

public interface WeatherService {
    CityInformation getWeather(String zipCode);
}
