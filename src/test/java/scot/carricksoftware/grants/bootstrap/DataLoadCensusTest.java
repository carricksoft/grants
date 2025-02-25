/*
 * Copyright (c)  22 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.census.CensusEntryService;
import scot.carricksoftware.grants.services.census.CensusEntryServiceImpl;
import scot.carricksoftware.grants.services.census.CensusServiceImpl;
import scot.carricksoftware.grants.services.people.PersonServiceImpl;
import scot.carricksoftware.grants.services.places.PlaceServiceImpl;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;

@SpringBootTest
class DataLoadCensusTest {

    DataLoadCensus dataLoadCensus;

    @SuppressWarnings("unused")
    @Mock
    PersonServiceImpl personServiceMock;

    @Mock
    CensusEntryServiceImpl censusEntryServiceMock;


    @Mock
    PlaceServiceImpl placeServiceImplMock;

    @Mock
    CensusServiceImpl censusServiceImplMock;

    final Place place = GetRandomPlace();
    final String date = LocalDate.now().format(ApplicationConstants.FORMATTER);

    @SuppressWarnings("unused")
    private CensusEntryService censusEntryService;

    @BeforeEach
    void setUp() {
        dataLoadCensus = new DataLoadCensus(censusServiceImplMock,
                placeServiceImplMock,
                censusEntryServiceMock,
                personServiceMock);
    }

    @Test
    void censusTest() {
        ArgumentCaptor<Census> censusCaptor = ArgumentCaptor.forClass(Census.class);
        when(placeServiceImplMock.findById(anyLong())).thenReturn(place);

        dataLoadCensus.load();
        verify(censusServiceImplMock).save(censusCaptor.capture());
        Census census = censusCaptor.getValue();
        assertEquals(census.getPlace().getName(), place.getName());
        assertEquals(census.getDate(), date);
    }

}