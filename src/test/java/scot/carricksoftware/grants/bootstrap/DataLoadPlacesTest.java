package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.services.places.countries.CountryServiceImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DataLoadPlacesTest {

    private DataLoadPlaces dataLoadPlaces;


    @Mock
    private CountryServiceImpl countryServiceMock;

    @BeforeEach
    public void setUp() {
        dataLoadPlaces = new DataLoadPlaces(countryServiceMock);
    }

    @Test
    public void scotlandIsCreatedTest() {
        ArgumentCaptor<Country> captor = ArgumentCaptor.forClass(Country.class);
        dataLoadPlaces.load();
        verify(countryServiceMock, atLeast(2)).save(captor.capture());
        assertTrue(captor.getAllValues().stream().anyMatch(country -> country.getName().equals("Scotland")));
    }

    @Test
    public void englandIsCreatedTest() {
        ArgumentCaptor<Country> captor = ArgumentCaptor.forClass(Country.class);
        dataLoadPlaces.load();
        verify(countryServiceMock, atLeast(2)).save(captor.capture());
        assertTrue(captor.getAllValues().stream().anyMatch(country -> country.getName().equals("England")));
    }


}