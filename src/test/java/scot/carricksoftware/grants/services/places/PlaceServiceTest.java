/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.repositories.places.PlaceRepository;

import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class PlaceServiceTest {

    private PlaceService placeService;

    @Mock
    private PlaceRepository placeRepositoryMock;

    @Mock
    private PlaceConverterImpl placeConverterImplMock;

    @Mock
    private PlaceCommandConverterImpl placeCommandConverterImplMock;

    Place place;

    @BeforeEach
    void setUp() {
        placeService = new PlaceServiceImpl(placeRepositoryMock,
                placeConverterImplMock,
                placeCommandConverterImplMock);
        place = new Place();
    }

    @Test
    void saveValidTest() {
        Region region = new Region();
        region.setName(GetRandomString());

        Country country = new Country();
        country.setName(GetRandomString());

        place.setName(GetRandomString());
        place.setCountry(country);
        place.setRegion(region);

        when(placeRepositoryMock.save(place)).thenReturn(place);

        Place returnPlace = placeService.save(place);

        assertEquals(country.getName(), returnPlace.getCountry().getName());
        assertEquals(region.getName(), returnPlace.getRegion().getName());
        assertEquals(place.getName(), returnPlace.getName());
    }


}