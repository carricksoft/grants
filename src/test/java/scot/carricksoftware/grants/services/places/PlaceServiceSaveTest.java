/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.exceptions.GrantsException;
import scot.carricksoftware.grants.repositories.places.PlaceRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import static scot.carricksoftware.grants.constants.ExceptionConstants.INVALID_PLACE;

@SpringBootTest
class PlaceServiceSaveTest {

    PlaceService placeService;

    @Mock
    PlaceRepository placeRepositoryMock;

    Place place;

    @BeforeEach
    void setUp() {
        placeService = new PlaceServiceImpl(placeRepositoryMock);
        place = new Place();
    }

    @Test
    void saveValidTest() throws GrantsException {
        Region edinburgh = new Region();
        edinburgh.setName("Edinburgh");

        Country scotland = new Country();
        scotland.setName("Scotland");

        place.setName("Elm Row");
        place.setCountry(scotland);
        place.setRegion(edinburgh);

        when(placeRepositoryMock.save(place)).thenReturn(place);

        Place returnPlace = placeService.save(place);

        assertEquals(scotland.getName(), returnPlace.getCountry().getName());
        assertEquals(edinburgh.getName(), returnPlace.getRegion().getName());
        assertEquals(place.getName(), returnPlace.getName());
    }

    @Test
    void saveTestNull() {
        GrantsException thrown = assertThrows(GrantsException.class, () -> placeService.save(null));

        assertEquals(INVALID_PLACE, thrown.getMessage());
    }

    @Test
    void saveTestNullCountry() {
        place.setName("name");
        place.setRegion(new Region());
        GrantsException thrown = assertThrows(GrantsException.class, () -> placeService.save(place));

        assertEquals(INVALID_PLACE, thrown.getMessage());
    }

    @Test
    void saveTestNullRegion() {

        place.setName("name");
        place.setCountry(new Country());
        GrantsException thrown = assertThrows(GrantsException.class, () -> placeService.save(place));

        assertEquals(INVALID_PLACE, thrown.getMessage());
    }

}