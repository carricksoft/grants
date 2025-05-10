/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.census.selectedcensus;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.repositories.census.CensusEntryRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
class SelectedCensusEntryServiceTest {

    private SelectedCensusEntryService service;

    @Mock
    CensusEntryRepository censusEntryRepositoryMock;

    @Mock
    Page<CensusEntry> pageMock;

    @Mock
    Census censusMock;


    @BeforeEach
    public void setUp() {
        service = new SelectedCensusEntryServiceImpl(censusEntryRepositoryMock);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(censusEntryRepositoryMock.count()).thenReturn(result);
        assertEquals(result, service.count());
    }


    @Test
    public void getPagedCensusEntriesTest() {
        List<CensusEntry> result = new ArrayList<>();
        CensusEntry censusEntry = GetRandomCensusEntry();
        censusEntry.setCensus(censusMock);
        result.add(censusEntry);

        when(censusEntryRepositoryMock.findAllByCensus(any(), any())).thenReturn(pageMock);
        when(pageMock.getContent()).thenReturn(result);

        assertEquals(result, service.getPagedCensusEntries(censusMock, 1));
    }

}