package weatherreporter;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocationWebServiceTest {
    LocationWebService locationWebService;

    @Before
    public void setUp() {
        locationWebService = new LocationWebService();
    }

    @Test
    public void getValidLocationForOneZipCode() {
        CityInformation cityInfo = new CityInformation("Houston", "TX", 77054);

        CityInformation infoFromService = locationWebService.getCityAndState("77054");

        assertEquals(cityInfo.getCityName(), infoFromService.getCityName());
        assertEquals(cityInfo.getStateName(), infoFromService.getStateName());
    }

    @Test
    public void getDetailsAboutInvalidZipCode() {
        CityInformation infoFromService = locationWebService.getCityAndState("7705csaddas4");
        assertEquals("Invalid", infoFromService.getStatusLocation());
    }

    @Test
    public void zipCodeIsValidButNotInUS() {
        CityInformation infoFromService = locationWebService.getCityAndState("88768");
        assertEquals("Invalid", infoFromService.getStatusLocation());
    }

    @Test
    public void zipCodeReturnResultButNotActualZipCode() {
        CityInformation infoFromService = locationWebService.getCityAndState("1234");
        assertEquals("Invalid", infoFromService.getStatusLocation());
    }

    @Test
    public void serviceIsNotAvailable() throws Exception {
        LocationWebService mockLocationService = mock(LocationWebService.class);
        when(mockLocationService.connectToLocationService(any())).thenThrow(new IOException());
        when(mockLocationService.getCityAndState(any())).thenCallRealMethod();
        
        try{
            mockLocationService.getCityAndState("65656");
        }catch (Exception e){}
    }
}
