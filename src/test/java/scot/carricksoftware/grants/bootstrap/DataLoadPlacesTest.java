package scot.carricksoftware.grants.bootstrap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.places.CountryService;
import scot.carricksoftware.grants.services.places.PlaceService;
import scot.carricksoftware.grants.services.places.RegionService;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DataLoadPlacesTest {

    private DataLoadPlaces dataLoadPlaces;

    @Mock
    private CountryService countryServiceMock;

    @Mock
    private RegionService regionServiceMock;

    @Mock
    private PlaceService placeServiceMock;

    @Before
    public void setUp() {
        dataLoadPlaces = new DataLoadPlaces(countryServiceMock, regionServiceMock, placeServiceMock);
    }

    @Test
    public void scotlandAndEnglandAreCreatedTest() {
        ArgumentCaptor<Country> captor = ArgumentCaptor.forClass(Country.class);
        dataLoadPlaces.load();
        verify(countryServiceMock, times(2)).save(captor.capture());
        assertTrue(captor.getAllValues().stream().anyMatch(country -> country.getName().equals("England")));
        assertTrue(captor.getAllValues().stream().anyMatch(country -> country.getName().equals("Scotland")));
    }

    @Test
    public void midlothianAndInvernessAreCreatedTest() {
        ArgumentCaptor<Country> captor = ArgumentCaptor.forClass(Country.class);
        dataLoadPlaces.load();
        verify(countryServiceMock, times(2)).save(captor.capture());
        assertTrue(captor.getAllValues().stream().anyMatch(country -> country.getName().equals("England")));
        assertTrue(captor.getAllValues().stream().anyMatch(country -> country.getName().equals("Scotland")));
    }

    @Test
    public void wilsonAvenueIsCreatedTest() {
        ArgumentCaptor<Place> captor = ArgumentCaptor.forClass(Place.class);
        dataLoadPlaces.load();
        verify(placeServiceMock, times(2)).save(captor.capture());
        boolean found = false;
        for (Place place : captor.getAllValues()) {
            if (place.getName().equals("2 Wilson Avenue") &&
                    place.getCountry().getName().equals("Scotland") &&
                    place.getRegion().getName().equals("Midlothian")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void bellfieldParkIsCreatedTest() {
        ArgumentCaptor<Place> captor = ArgumentCaptor.forClass(Place.class);
        dataLoadPlaces.load();
        verify(placeServiceMock, times(2)).save(captor.capture());
        boolean found = false;
        for (Place place : captor.getAllValues()) {
            if (place.getName().equals("5 Bellfield Park") &&
                    place.getCountry().getName().equals("Scotland") &&
                    place.getRegion().getName().equals("Inverness")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }


}