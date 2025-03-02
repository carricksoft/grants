/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.places.places;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.repositories.places.PlaceRepository;
import scot.carricksoftware.grants.services.places.PlaceService;
import scot.carricksoftware.grants.services.places.PlaceServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlaceServiceFindTest {

    PlaceService placeService;

    @Mock
    PlaceRepository placeRepositoryMock;

    @Mock
    PlaceConverterImpl placeConverterImplMock;

    @Mock
    PlaceCommandConverterImpl placeCommandConverterImplMock;

    @Before
    public void setUp() {
        placeService = new PlaceServiceImpl(
                placeRepositoryMock,
                placeConverterImplMock,
                placeCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @SuppressWarnings("EmptyMethod")
    @Test
    public void findByIdTest() {
        Long id = GetRandomLong();
        Place place = GetRandomPlace();
        when(placeRepositoryMock.findById(id)).thenReturn(Optional.of(place));
        assertEquals(place, placeService.findById(id));
    }

    @Test
    public void findByIdNullTest() {
        Long id = GetRandomLong();
        when(placeRepositoryMock.findById(id)).thenReturn(Optional.empty());
        assertNull(placeService.findById(id));
    }

    @Test
    public void findAllTest() {
        List<Place> testList = new ArrayList<>();
        Place testPlace = new Place();
        testList.add(testPlace);
        when(placeRepositoryMock.findAll())
                .thenReturn(testList);
        assertEquals(testList, placeService.findAll());
        verify(placeRepositoryMock).findAll();
    }

}