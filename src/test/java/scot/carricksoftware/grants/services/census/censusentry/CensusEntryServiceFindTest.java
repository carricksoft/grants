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
import scot.carricksoftware.grants.converters.census.censusentry.CensusEntryCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.censusentry.CensusEntryConverterImpl;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.repositories.census.CensusEntryRepository;
import scot.carricksoftware.grants.services.censusentry.CensusEntryService;
import scot.carricksoftware.grants.services.censusentry.CensusEntryServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;

@SpringBootTest
class CensusEntryServiceFindTest {

    CensusEntryService censusEntryService;

    @Mock
    CensusEntryRepository censusEntryRepositoryMock;

    @Mock
    CensusEntryConverterImpl censusEntryConverterImplMock;

    @Mock
    CensusEntryCommandConverterImpl censusEntryCommandConverterImplMock;

    @BeforeEach
    void setUp() {
        censusEntryService = new CensusEntryServiceImpl(
                censusEntryRepositoryMock,
                censusEntryConverterImplMock,
                censusEntryCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @SuppressWarnings("EmptyMethod")
    @Test
    void findByIdTest() {
        Long id = GetRandomLong();
        CensusEntry censusEntry = GetRandomCensusEntry();
        when(censusEntryRepositoryMock.findById(id)).thenReturn(Optional.of(censusEntry));
        assertEquals(censusEntry, censusEntryService.findById(id));
    }

    @Test
    void findByIdNullTest() {
        Long id = GetRandomLong();
        when(censusEntryRepositoryMock.findById(id)).thenReturn(Optional.empty());
        assertNull(censusEntryService.findById(id));
    }

}