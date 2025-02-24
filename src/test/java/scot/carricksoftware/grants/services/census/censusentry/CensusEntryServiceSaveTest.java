/*
 * Copyright (c)  24 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.census.censusentry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.converters.census.censusEntry.CensusEntryCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.censusEntry.CensusEntryConverterImpl;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.repositories.census.CensusEntryRepository;
import scot.carricksoftware.grants.services.census.CensusEntryService;
import scot.carricksoftware.grants.services.census.CensusEntryServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;

@SpringBootTest
class CensusEntryServiceSaveTest {

    CensusEntryService censusEntryService;

    @Mock
    CensusEntryRepository censusEntryRepositoryMock;

    @Mock
    CensusEntryConverterImpl censusEntryConverterImplMock;

    @Mock
    CensusEntryCommandConverterImpl censusEntryCommandConverterImplMock;


    @BeforeEach
    void setUp() {
        censusEntryService = new CensusEntryServiceImpl(censusEntryRepositoryMock,
                censusEntryConverterImplMock,
                censusEntryCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @SuppressWarnings("EmptyMethod")
    @Test
    void saveTest() {
        CensusEntry censusEntry = new CensusEntry();
        when(censusEntryRepositoryMock.save(censusEntry)).thenReturn(censusEntry);
        assertEquals(censusEntry, censusEntryService.save(censusEntry));
    }

    @Test
    void saveCensusEntryCommandTest() {
        CensusEntry censusEntry = GetRandomCensusEntry();
        CensusEntryCommand censusEntryCommand = new CensusEntryCommand();
        when(censusEntryCommandConverterImplMock.convert(censusEntryCommand)).thenReturn(censusEntry);
        when(censusEntryRepositoryMock.save(censusEntry)).thenReturn(censusEntry);
        when(censusEntryConverterImplMock.convert((censusEntry))).thenReturn(censusEntryCommand);

        assertEquals(censusEntryCommand, censusEntryService.saveCensusEntryCommand(censusEntryCommand));
    }


}