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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PlaceServiceTest {

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
        Place elmRow = new Place();
        places.add(elmRow);
        when(placeRepositoryMock.findAll()).thenReturn(places);
        assertEquals(places, placeService.findAll());
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    void findByIdTest() {
        assertTrue(true);
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    void saveTest() {
        assertTrue(true);
    }
}