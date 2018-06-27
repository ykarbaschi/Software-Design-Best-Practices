package weatherreporter;

public class CityInformation {

    private String statusLocation;
    private String statusWeather;
    private String cityName;
    private String stateAbbreviation;
    private int zipCode;

    private int minTemperature;
    private int maxTemperature;
    private String forecast24h;

    public String getCityName() {
        return cityName;
    }

    public String getStateName() {
        return stateAbbreviation;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getForecast24h() {
        return forecast24h;
    }

    public String getStatusLocation() {
        return statusLocation;
    }

    public String getStatusWeather() {
        return statusWeather;
    }

    public CityInformation() {
        statusLocation = "Invalid";
        statusWeather = "Invalid";
    }

    public CityInformation(String nameOfCity, String stateAbbreviated, int zipCodes) {
        cityName = nameOfCity;
        stateAbbreviation = stateAbbreviated;
        zipCode = zipCodes;
        statusLocation = "Valid";
        statusWeather = "Invalid";
    }

    public CityInformation(int minTemp, int maxTemp, String forecast24, int zipcode) {
        minTemperature = minTemp;
        maxTemperature = maxTemp;
        forecast24h = forecast24;
        zipCode = zipcode;
        statusWeather = "Valid";
        statusLocation = "Invalid";
    }

    public CityInformation(int zipcode, String city, String state, int minTemp, int maxTemp, String forecast) {
        cityName = city;
        stateAbbreviation = state;
        minTemperature = minTemp;
        maxTemperature = maxTemp;
        forecast24h = forecast;
        zipCode = zipcode;
        statusLocation = "Valid";
        statusWeather = "Valid";
    }

    public void combine(CityInformation cityInformation) {

        if (cityInformation.getStatusLocation().equals("Valid")) {
            cityName = cityInformation.getCityName();
            zipCode = cityInformation.getZipCode();
            stateAbbreviation = cityInformation.getStateName();
            statusLocation = cityInformation.getStatusLocation();
        }

        if (cityInformation.getStatusWeather().equals("Valid")) {
            zipCode = cityInformation.getZipCode();
            minTemperature = cityInformation.getMinTemperature();
            maxTemperature = cityInformation.getMaxTemperature();
            forecast24h = cityInformation.getForecast24h();
            statusWeather = cityInformation.getStatusWeather();
        }
    }
}