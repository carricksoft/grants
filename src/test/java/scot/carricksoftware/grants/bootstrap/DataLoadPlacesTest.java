/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.exceptions.GrantsException;
import scot.carricksoftware.grants.services.places.CountryService;
import scot.carricksoftware.grants.services.places.PlaceService;
import scot.carricksoftware.grants.services.places.RegionService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
class DataLoadPlacesTest {

    DataLoadPlaces dataLoadPlaces;


    @Mock
    CountryService countryServiceMock;

    @Mock
    private RegionService regionServiceMock;

    @Mock
    private PlaceService placeServiceMock;

    @BeforeEach
    void setUp() {
        dataLoadPlaces = new DataLoadPlaces(countryServiceMock, regionServiceMock, placeServiceMock);
    }


    @Test
    void testCountries() throws GrantsException {
        dataLoadPlaces.load();
        verify(countryServiceMock).save(any(Country.class));
    }

    @Test
    void testRegions() throws GrantsException {
        dataLoadPlaces.load();
        verify(regionServiceMock).save(any(Region.class));
    }

    @Test
    void testPlaces() throws GrantsException {
        dataLoadPlaces.load();
        verify(placeServiceMock).save(any(Place.class));
    }
}