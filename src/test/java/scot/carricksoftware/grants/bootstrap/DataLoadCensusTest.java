/*
 * Copyright (c)  22 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.census.CensusEntryService;
import scot.carricksoftware.grants.services.census.CensusEntryServiceImpl;
import scot.carricksoftware.grants.services.census.CensusServiceImpl;
import scot.carricksoftware.grants.services.people.PersonServiceImpl;
import scot.carricksoftware.grants.services.places.PlaceServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;

@ExtendWith(SpringExtension.class)
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


    @SuppressWarnings("unused")
    private CensusEntryService censusEntryService;

    @SuppressWarnings("unused")
    @BeforeEach
    void setUp() {
        dataLoadCensus = new DataLoadCensus(censusServiceImplMock,
                placeServiceImplMock,
                censusEntryServiceMock,
                personServiceMock);
        Person person = GetRandomPerson();
    }

    @Test
    void censusTest() {
        dataLoadCensus.load();
        verify(censusServiceImplMock).save(any(Census.class));
    }

    @Test
    void censusEntryTest() {
        dataLoadCensus.load();
        verify(censusEntryServiceMock).save(any(CensusEntry.class));
    }

}