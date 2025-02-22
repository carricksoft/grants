/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.services.places.CountryService;
import scot.carricksoftware.grants.services.places.PlaceService;
import scot.carricksoftware.grants.services.places.RegionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
    void testCountries() {
        ArgumentCaptor<Country> countryCaptor = ArgumentCaptor.forClass(Country.class);

        when(countryServiceMock.save(countryCaptor.capture())).thenReturn(new Country());
        dataLoadPlaces.load();
        Country[] countries = countryCaptor.getAllValues().toArray(new Country[0]);
        assertEquals(2, countries.length);
        assertEquals("Scotland", countries[0].getName());
        assertEquals("England", countries[1].getName());
    }

    @Test
    void testRegions() {
        ArgumentCaptor<Region> regionCaptor = ArgumentCaptor.forClass(Region.class);

        when(regionServiceMock.save(regionCaptor.capture())).thenReturn(new Region());
        dataLoadPlaces.load();
        Region[] regions = regionCaptor.getAllValues().toArray(new Region[0]);
        assertEquals(1, regions.length);
        assertEquals("Midlothian", regions[0].getName());
    }

    @Test
    void testPlaces() {
        ArgumentCaptor<Place> countryCaptor = ArgumentCaptor.forClass(Place.class);

        when(placeServiceMock.save(countryCaptor.capture())).thenReturn(new Place());
        dataLoadPlaces.load();
        Place[] places = countryCaptor.getAllValues().toArray(new Place[0]);
        assertEquals(1, places.length);
        assertEquals("Wilson Avenue", places[0].getName());
        assertEquals("Scotland", places[0].getCountry().getName());
        assertEquals("Midlothian", places[0].getRegion().getName());
    }
}