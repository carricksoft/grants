/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.repositories.places.PlaceRepository;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;

@SpringBootTest
class PlaceServiceFindTest {

    PlaceService placeService;

    @Mock
    PlaceRepository placeRepositoryMock;

    @BeforeEach
    void setUp() {
        placeService = new PlaceServiceImpl(placeRepositoryMock);
    }

    @Test
    void findAllTest() {
        HashSet<Place> places = new HashSet<>();
        Place place = new Place();
        places.add(place);
        when(placeRepositoryMock.findAll()).thenReturn(places);
        assertEquals(places, placeService.findAll());
    }


    @SuppressWarnings("EmptyMethod")
    @Test
    void findByIdTest() {
        Long id = GetRandomLong();
        Place place = GetRandomPlace();
        when(placeRepositoryMock.findById(id)).thenReturn(Optional.of(place));
        assertEquals(place, placeService.findById(id));
    }

    @Test
    void findByIdNullTest() {
        Long id = GetRandomLong();
        when(placeRepositoryMock.findById(id)).thenReturn(Optional.empty());
        assertNull(placeService.findById(id));
    }

}