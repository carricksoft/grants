/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.censusentry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.census.censusentry.CensusEntryCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.censusentry.CensusEntryConverterImpl;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.censusentry.CensusEntryService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.PlaceService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
class CensusEntryFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private CensusEntryFormControllerImpl censusEntryController;

    @Mock
    private CensusEntryService censusEntryServiceMock;

    @SuppressWarnings("unused")
    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    private PersonService personServiceMock;


    @Mock
    private CensusEntryCommandConverterImpl censusEntryCommandConverterMock;

    @Mock
    private CensusEntryConverterImpl censusEntryConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;


    @Mock
    BindingResult bindingResultMock;

    @Autowired
    private CensusEntryCommand censusEntryCommand;


    @BeforeEach
    void setUp() {
        censusEntryController = new CensusEntryFormControllerImpl(censusEntryServiceMock,
                censusServiceMock,
                censusEntryCommandConverterMock,
                censusEntryConverterMock,
                personServiceMock,
                capitalisationMock);
    }

    @Test
    void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        censusEntryCommand.setId(id);
        when(censusEntryServiceMock.saveCensusEntryCommand(any(CensusEntryCommand.class))).thenReturn(censusEntryCommand);
        assertEquals("redirect:/censusEntry/4/show", censusEntryController.saveOrUpdate(censusEntryCommand, bindingResultMock));
    }

    @Test
    void saveOrUpdateErrorsTest() {
        Long id = 4L;
        censusEntryCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        when(censusEntryServiceMock.saveCensusEntryCommand(any(CensusEntryCommand.class))).thenReturn(censusEntryCommand);
        assertEquals("censusentry/form", censusEntryController.saveOrUpdate(censusEntryCommand, bindingResultMock));
    }

}