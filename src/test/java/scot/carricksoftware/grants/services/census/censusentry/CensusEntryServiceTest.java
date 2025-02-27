/*
 * Copyright (c)  24 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.census.censusentry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.census.census.CensusCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.census.CensusConverterImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.repositories.census.CensusRepository;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.census.CensusServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;

@SpringBootTest
class CensusEntryServiceTest {

    CensusService censusService;

    @Mock
    CensusRepository censusRepositoryMock;

    @Mock
    CensusConverterImpl censusConverterImplMock;

    @Mock
    CensusCommandConverterImpl censusCommandConverterImplMock;


    @BeforeEach
    void setUp() {
        censusService = new CensusServiceImpl(censusRepositoryMock,
                censusConverterImplMock,
                censusCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @Mock
    Page<Census> pageMock;


    @SuppressWarnings("EmptyMethod")
    @Test
    void deleteByIdTest() {
        Long id = GetRandomLong();
        censusService.deleteById(id);
        verify(censusRepositoryMock).deleteById(id);
    }

    @Test
    void CountTest() {
        long result = GetRandomLong();
        when(censusRepositoryMock.count()).thenReturn(result);
        assertEquals(result, censusService.count());
    }

    @Test
    void getPagedCensusesTest() {
        List<Census> result = new ArrayList<>();
        Census census = GetRandomCensus();
        result.add(census);
        when(pageMock.getContent()).thenReturn(result);
        when(censusRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, censusService.getPagedCensuses(0));
    }


}