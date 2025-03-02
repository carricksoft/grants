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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import scot.carricksoftware.grants.converters.census.censusentry.CensusEntryCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.censusentry.CensusEntryConverterImpl;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.repositories.census.CensusEntryRepository;
import scot.carricksoftware.grants.services.censusentry.CensusEntryService;
import scot.carricksoftware.grants.services.censusentry.CensusEntryServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CensusEntryServiceTest {

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

    @Mock
    Page<CensusEntry> pageMock;


    @SuppressWarnings("EmptyMethod")
    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        censusEntryService.deleteById(id);
        verify(censusEntryRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(censusEntryRepositoryMock.count()).thenReturn(result);
        assertEquals(result, censusEntryService.count());
    }

    @Test
    public void getPagedCensusEntryEntriesTest() {
        List<CensusEntry> result = new ArrayList<>();
        CensusEntry censusEntry = GetRandomCensusEntry();
        result.add(censusEntry);
        when(pageMock.getContent()).thenReturn(result);
        when(censusEntryRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, censusEntryService.getPagedCensusEntries(0));
    }


}