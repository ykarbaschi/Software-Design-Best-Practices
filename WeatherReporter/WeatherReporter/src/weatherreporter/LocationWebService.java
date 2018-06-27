package weatherreporter;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocationWebService implements LocationService {

    @Override
    public CityInformation getCityAndState(String zipcode) {
        JsonObject object;
        List<JsonValue> cities;
        object = Json.parse(fetchDataFromApi(zipcode)).asObject();

        String status = object.get("status").asString();
        if (status.contentEquals("OK"))
            cities = collectUSCitiesWithCorrectZipCode(object.get("results").asArray(), zipcode);
        else return new CityInformation();

        return getOneCityFromAllMatches(cities, zipcode);
    }

    private String fetchDataFromApi(String zipCode) {
        String serviceResponse;
        try {
            serviceResponse = connectToLocationService(zipCode);
        } catch (IOException e) {
            return "Service is unavailable.";
        }
        return serviceResponse;
    }

    private CityInformation getOneCityFromAllMatches(List<JsonValue> cities, String zipCode) {
        String cityName = "";
        String state = "";

        if (cities.size() != 0) {
            for (JsonValue item : cities.get(0).asObject().get("address_components").asArray()) {
                if (item.asObject().get("types").asArray().get(0).asString().contentEquals("administrative_area_level_1")) {
                    state = item.asObject().get("short_name").asString();
                }

                if (item.asObject().get("types").asArray().get(0).asString().contentEquals("locality")) {
                    cityName = item.asObject().get("short_name").asString();
                }
            }
            return new CityInformation(cityName, state, Integer.parseInt(zipCode));
        } else return new CityInformation();
    }

    private List<JsonValue> collectUSCitiesWithCorrectZipCode(JsonArray details, String zipcode) {
        List<JsonValue> cities = new ArrayList<>();
        String actualPostalCode = "";
        String country = "";
        for (JsonValue eachResult : details) {

            JsonArray detailsOfEachEntry = eachResult.asObject().get("address_components").asArray();

            for (JsonValue item : detailsOfEachEntry) {

                if (item.asObject().get("types").asArray().get(0).asString().contentEquals("country")) {
                    country = item.asObject().get("short_name").asString();
                }

                if (item.asObject().get("types").asArray().get(0).asString().contentEquals("postal_code")) {
                    actualPostalCode = item.asObject().get("short_name").asString();
                }
            }

            if (country.contentEquals("US") && actualPostalCode.contentEquals(zipcode))
                cities.add(eachResult);
        }
        return cities;
    }

    String connectToLocationService(String zipCode) throws IOException {
        String serviceResponse;
        serviceResponse = Jsoup.connect("http://maps.googleapis.com/maps/api/geocode/json?address=" + zipCode)
                .ignoreContentType(true).execute().body();
        return serviceResponse;
    }
}

