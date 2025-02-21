/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.places.PlaceCommand;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.repositories.places.PlaceRepository;
import scot.carricksoftware.grants.services.places.PlaceService;
import scot.carricksoftware.grants.services.places.PlaceServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@SpringBootTest
class PlaceServiceSaveTest {

    PlaceService placeService;

    @Mock
    PlaceRepository placeRepositoryMock;

    @Mock
    PlaceConverterImpl placeConverterImplMock;

    @Mock
    PlaceCommandConverterImpl placeCommandConverterImplMock;


    @BeforeEach
    void setUp() {
        placeService = new PlaceServiceImpl(placeRepositoryMock,
                placeConverterImplMock,
                placeCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @SuppressWarnings("EmptyMethod")
    @Test
    void saveTest() {
        Place place = new Place();
        place.setName(GetRandomString());

        when(placeRepositoryMock.save(place)).thenReturn(place);

        assertEquals(place, placeService.save(place));
    }

    @Test
    void savePlaceCommandTest() {
        Place place = GetRandomPlace();
        PlaceCommand placeCommand = new PlaceCommand();
        when(placeCommandConverterImplMock.convert(placeCommand)).thenReturn(place);
        when(placeRepositoryMock.save(place)).thenReturn(place);
        when(placeConverterImplMock.convert((place))).thenReturn(placeCommand);

        assertEquals(placeCommand, placeService.savePlaceCommand(placeCommand));
    }


}