# Design a Weather Reporter Service

In this project, we will write a program that will print the weather report for different cities.

The program will read a text file which contains a list of zip codes and print (in sorted order of the city names) the name of the city, the 2-character state, the zip code, the forecast minimum and maximum temperature, and condition for the next 24 hours. Condition, for example, may be Sunny, partly cloudy, rainy, etc. In addition it will also print the name of the warmest city (from the maximum temperatures) and the name of the coldest city (from the minimum temperatures).

For example, if the input file were to contain the following zip codes:

`77201
77204
81611`

The output format may be like this, for example:

Weather data:

|City|State|Zip Code|Min|Max|Condition
|:---:|:---:|:---:|:---:|:---:|:---:|
|Austin|CO|81611|5|11|Snow|
|Dallas|TX|75201|61|75|Sunny|
|Houston|TX|77204|66|82|Sunny|

Hottest city:

|Houston|TX|77204
|:---:|:---:|:---:|

Coldest City:

|Austin|CO|81611
|:---:|:---:|:---:|

Don't forget to take small steps. Postpone dealing with dependencies as much as possible. Think though the different logical parts for this program and start creating one small step at a time.

You may use any service to get the data. Here are some suggestions:

For the zip code to formatted address (to get city and state):

`http://maps.googleapis.com/maps/api/geocode/json?address=ZIPCODE`

To get the forecast, give a zip code:

`http://graphical.weather.gov/xml/sample_products/browser_interface/ndfdBrowserClientByDay.php?zipCodeList=ZIPCODE&format=24+hourly&numDays=1`