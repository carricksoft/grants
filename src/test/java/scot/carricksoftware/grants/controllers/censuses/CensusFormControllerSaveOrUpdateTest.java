/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.censuses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.controllers.census.CensusFormControllerImpl;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.census.CensusCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.CensusConverterImpl;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.places.PlaceService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
class CensusFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private CensusFormControllerImpl censusController;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private CensusCommandConverterImpl censusCommandConverterMock;

    @Mock
    private CensusConverterImpl censusConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;


    @Mock
    BindingResult bindingResultMock;

    @Autowired
    private CensusCommand censusCommand;


    @BeforeEach
    void setUp() {
        censusController = new CensusFormControllerImpl(censusServiceMock,
                censusCommandConverterMock,
                censusConverterMock,
                placeServiceMock,
                capitalisationMock);
    }

    @Test
    void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        censusCommand.setId(id);
        when(censusServiceMock.saveCensusCommand(any(CensusCommand.class))).thenReturn(censusCommand);
        assertEquals("redirect:/census/4/show", censusController.saveOrUpdate(censusCommand, bindingResultMock));
    }

    @Test
    void saveOrUpdateErrorsTest() {
        Long id = 4L;
        censusCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        when(censusServiceMock.saveCensusCommand(any(CensusCommand.class))).thenReturn(censusCommand);
        assertEquals("census/form", censusController.saveOrUpdate(censusCommand, bindingResultMock));
    }

}