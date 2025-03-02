/*
 * Copyright (c)  24 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.census.censusentry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.converters.census.censusentry.CensusEntryCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.censusentry.CensusEntryConverterImpl;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.repositories.census.CensusEntryRepository;
import scot.carricksoftware.grants.services.censusentry.CensusEntryService;
import scot.carricksoftware.grants.services.censusentry.CensusEntryServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CensusEntryServiceSaveTest {

    CensusEntryService censusEntryService;

    @Mock
    CensusEntryRepository censusEntryRepositoryMock;

    @Mock
    CensusEntryConverterImpl censusEntryConverterImplMock;

    @Mock
    CensusEntryCommandConverterImpl censusEntryCommandConverterImplMock;


    @Before
    public void setUp() {
        censusEntryService = new CensusEntryServiceImpl(censusEntryRepositoryMock,
                censusEntryConverterImplMock,
                censusEntryCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @SuppressWarnings("EmptyMethod")
    @Test
    public void saveTest() {
        CensusEntry censusEntry = new CensusEntry();
        when(censusEntryRepositoryMock.save(censusEntry)).thenReturn(censusEntry);
        assertEquals(censusEntry, censusEntryService.save(censusEntry));
    }

    @Test
    public void saveCensusEntryCommandTest() {
        CensusEntry censusEntry = GetRandomCensusEntry();
        CensusEntryCommand censusEntryCommand = new CensusEntryCommand();
        when(censusEntryCommandConverterImplMock.convert(censusEntryCommand)).thenReturn(censusEntry);
        when(censusEntryRepositoryMock.save(censusEntry)).thenReturn(censusEntry);
        when(censusEntryConverterImplMock.convert((censusEntry))).thenReturn(censusEntryCommand);

        assertEquals(censusEntryCommand, censusEntryService.saveCensusEntryCommand(censusEntryCommand));
    }


}