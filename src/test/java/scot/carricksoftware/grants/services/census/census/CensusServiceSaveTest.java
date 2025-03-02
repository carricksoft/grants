/*
 * Copyright (c)  24 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.census.census;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.converters.census.census.CensusCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.census.CensusConverterImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.repositories.census.CensusRepository;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.census.CensusServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCensus;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CensusServiceSaveTest {

    CensusService censusService;

    @Mock
    CensusRepository censusRepositoryMock;

    @Mock
    CensusConverterImpl censusConverterImplMock;

    @Mock
    CensusCommandConverterImpl censusCommandConverterImplMock;


    @Before
    public void setUp() {
        censusService = new CensusServiceImpl(censusRepositoryMock,
                censusConverterImplMock,
                censusCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @SuppressWarnings("EmptyMethod")
    @Test
    public void saveTest() {
        Census census = new Census();
        when(censusRepositoryMock.save(census)).thenReturn(census);
        assertEquals(census, censusService.save(census));
    }

    @Test
    public void saveCensusCommandTest() {
        Census census = GetRandomCensus();
        CensusCommand censusCommand = new CensusCommand();
        when(censusCommandConverterImplMock.convert(censusCommand)).thenReturn(census);
        when(censusRepositoryMock.save(census)).thenReturn(census);
        when(censusConverterImplMock.convert((census))).thenReturn(censusCommand);

        assertEquals(censusCommand, censusService.saveCensusCommand(censusCommand));
    }


}