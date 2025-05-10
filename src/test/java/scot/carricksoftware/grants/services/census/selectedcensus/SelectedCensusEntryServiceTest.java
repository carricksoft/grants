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
import scot.carricksoftware.grants.repositories.census.CensusEntryRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
class SelectedCensusEntryServiceTest {

    private SelectedCensusEntryService service;

    @Mock
    CensusEntryRepository censusEntryRepositoryMock;

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
}