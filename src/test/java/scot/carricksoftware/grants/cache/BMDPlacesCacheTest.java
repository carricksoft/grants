/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
public class BMDPlacesCacheTest {


    @Mock
    PersonService personServiceMock;

    @Mock
    PlaceService placeServiceMock;

    @Mock
    OrganisationService organisationServiceMock;

    private BMDCache cache;

    private List<Place> placesList = null;

    @BeforeEach
    void setUp() {
        placesList = new ArrayList<>();
        placesList.add(GetRandomPlace());
        when(placeServiceMock.findAll()).thenReturn(placesList);
        cache = new BMDCacheImpl(personServiceMock, placeServiceMock, organisationServiceMock);
    }

    @Test
    void nullPlacesTest() {
        assertEquals(placesList,cache.getPlaces());
        verify(placeServiceMock).findAll();
    }

    @Test
    void alreadyExistsTest() {
        assertEquals(placesList,cache.getPlaces());
        assertEquals(placesList,cache.getPlaces());
        verify(placeServiceMock, times(1)).findAll();
    }

    @Test
    void invalidateTest() {
        assertEquals(placesList,cache.getPlaces());
        cache.invalidatePlaces();
        assertEquals(placesList,cache.getPlaces());
        verify(placeServiceMock, times(2)).findAll();
    }
}