package weatherreporter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.jsoup.Jsoup;

import java.io.IOException;

public class WeatherWebService implements WeatherService {
    @Override
    public CityInformation getWeather(String zipCode) {
        String serviceResponseInXML = fetchDataFromApi(zipCode);
        String maxTemp = "0", minTemp = "0", forecast = "";
        try {
            if (!serviceResponseInXML.isEmpty()) {
                JSONObject serviceResponse;

                serviceResponse = XML.toJSONObject(serviceResponseInXML);

                maxTemp = serviceResponse.getJSONObject("dwml").getJSONObject("data").getJSONObject("parameters")
                        .getJSONArray("temperature").getJSONObject(0).get("value").toString();

                minTemp = serviceResponse.getJSONObject("dwml").getJSONObject("data").getJSONObject("parameters")
                        .getJSONArray("temperature").getJSONObject(1).get("value").toString();

                forecast = serviceResponse.getJSONObject("dwml").getJSONObject("data").getJSONObject("parameters")
                        .getJSONObject("weather").getJSONObject("weather-conditions").get("weather-summary").toString();

            } else return new CityInformation();
        } catch (JSONException jsonException) {
            return new CityInformation();
        }
        return new CityInformation(Integer.parseInt(minTemp), Integer.parseInt(maxTemp), forecast, Integer.parseInt(zipCode));
    }

    private String fetchDataFromApi(String zipCode) {
        String serviceResponse;
        try {
            serviceResponse = connectToWeatherService(zipCode);
        } catch (IOException e) {
            return "Service is unavailable.";
        }
        return serviceResponse;
    }

    String connectToWeatherService(String zipCode) throws IOException {
        String serviceResponse;
        serviceResponse = Jsoup.connect("http://graphical.weather.gov/xml/sample_products/browser_interface/ndfdBrowserClientByDay.php?zipCodeList="
                + zipCode + "&format=24+hourly&numDays=1").ignoreContentType(true).execute().body();

        return serviceResponse;
    }
}
