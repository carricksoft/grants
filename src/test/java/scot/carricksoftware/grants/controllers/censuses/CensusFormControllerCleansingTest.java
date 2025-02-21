/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.censuses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.controllers.census.CensusFormControllerImpl;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.census.CensusCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.CensusConverterImpl;
import scot.carricksoftware.grants.services.census.CensusService;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class CensusFormControllerCleansingTest {

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private CensusFormControllerImpl censusController;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    private CensusCommandConverterImpl censusCommandConverterMock;

    @Mock
    private CensusConverterImpl censusConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @SuppressWarnings("unused")
    @Mock
    CensusCommand censusCommandMock;

    @SuppressWarnings("unused")
    @Mock
    BindingResult bindingResultMock;


    @BeforeEach
    void setUp() {
        censusController = new CensusFormControllerImpl(censusServiceMock,
                censusCommandConverterMock,
                censusConverterMock,
                capitalisationMock);
    }

    @Test
    void dummyTest() {
        assertTrue(true);
    }

}