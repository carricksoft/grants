/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.census.census.CensusCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.census.CensusConverterImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.repositories.census.CensusRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;

@SpringBootTest
class CensusServiceFindTest {

    CensusService censusService;

    @Mock
    CensusRepository censusRepositoryMock;

    @Mock
    CensusConverterImpl censusConverterImplMock;

    @Mock
    CensusCommandConverterImpl censusCommandConverterImplMock;

    @BeforeEach
    void setUp() {
        censusService = new CensusServiceImpl(
                censusRepositoryMock,
                censusConverterImplMock,
                censusCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @SuppressWarnings("EmptyMethod")
    @Test
    void findByIdTest() {
        Long id = GetRandomLong();
        Census census = GetRandomCensus();
        when(censusRepositoryMock.findById(id)).thenReturn(Optional.of(census));
        assertEquals(census, censusService.findById(id));
    }

    @Test
    void findByIdNullTest() {
        Long id = GetRandomLong();
        when(censusRepositoryMock.findById(id)).thenReturn(Optional.empty());
        assertNull(censusService.findById(id));
    }

}