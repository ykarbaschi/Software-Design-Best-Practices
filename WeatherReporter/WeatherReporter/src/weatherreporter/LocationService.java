package weatherreporter;

public interface LocationService {
    CityInformation getCityAndState(String zipCode);
}
