/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.censuses;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.controllers.census.CensusFormControllerImpl;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.census.census.CensusCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.census.CensusConverterImpl;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.places.PlaceService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CensusFormControllerSaveOrUpdateTest {

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

    CensusCommand censusCommand;

    @Before
    public void setup() {
        censusCommand = new CensusCommand();
    }


    @Before
    public void setUp() {
        censusController = new CensusFormControllerImpl(censusServiceMock,
                censusCommandConverterMock,
                censusConverterMock,
                placeServiceMock,
                capitalisationMock);
    }


    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        censusCommand.setId(id);
        when(censusServiceMock.saveCensusCommand(any(CensusCommand.class))).thenReturn(censusCommand);
        assertEquals("redirect:/census/4/show", censusController.saveOrUpdate(censusCommand, bindingResultMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        censusCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        when(censusServiceMock.saveCensusCommand(any(CensusCommand.class))).thenReturn(censusCommand);
        assertEquals("census/form", censusController.saveOrUpdate(censusCommand, bindingResultMock));
    }

}