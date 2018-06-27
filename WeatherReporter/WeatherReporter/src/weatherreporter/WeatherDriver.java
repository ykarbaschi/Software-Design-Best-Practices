package weatherreporter;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WeatherDriver {

    public static void main(String[] args) {
        String currentDirectory = new File("").getAbsolutePath();
        String zipCode = null;
        List<String> listZipCodes = new ArrayList<String>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(currentDirectory + "/WeatherReporter/Input/zipcodes"));

            while ((zipCode = br.readLine()) != null) {
                if(!listZipCodes.contains(zipCode))
                listZipCodes.add(zipCode);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error in zip code text file");
        } catch (IOException ex) {
            System.out.println("error reading file");
        } catch (Exception exception) {
            System.out.println("Other exception");
        }

        WeatherReporter weatherReporter = new WeatherReporter();
        weatherReporter.setLocationService(new LocationWebService());
        weatherReporter.setWeatherService(new WeatherWebService());

        List<CityInformation> result = weatherReporter.getCitiesInformation(listZipCodes);

        List<CityInformation> sortedResultByName = weatherReporter.sortByCityName(result);

        System.out.println("Weather Data");
        System.out.println("City\tState\tZipCode\tMin\tMax\tCondition");
        for (CityInformation city : sortedResultByName) {
            System.out.println(city.getCityName() + "\t" + city.getStateName() + "\t" + city.getZipCode() + "\t" + city.getMinTemperature()
                    + "\t" + city.getMaxTemperature() + "\t" + city.getForecast24h());
        }

        List<CityInformation> listOfHottestCities = weatherReporter.findWarmestCities(result);
        System.out.println("\nHottest City");
        for (CityInformation hottestCity : listOfHottestCities) {
            System.out.println(hottestCity.getCityName() + "\t" + hottestCity.getStateName() + "\t" + hottestCity.getZipCode());
        }

        List<CityInformation> listOfColdestCities = weatherReporter.findColdestCities(result);
        System.out.println("\nColdest City");
        for (CityInformation coldestCity : listOfColdestCities) {
            System.out.println(coldestCity.getCityName() + "\t" + coldestCity.getStateName() + "\t" + coldestCity.getZipCode());
        }
    }
}
