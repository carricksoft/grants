/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.censusentries;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.controllers.censusentry.CensusEntryFormControllerImpl;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.census.censusentry.CensusEntryCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.censusentry.CensusEntryConverterImpl;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.censusentry.CensusEntryService;
import scot.carricksoftware.grants.services.people.PersonService;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomValues.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CensusEntryFormControllerTest {

    @SuppressWarnings("unused")
    private CensusEntryFormControllerImpl censusEntryController;


    @Mock
    private PersonService personServiceMock;

    @Mock
    private CensusEntryService censusEntryServiceMock;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    private CensusEntryCommandConverterImpl censusEntryCommandConverterMock;

    @Mock
    private CensusEntryConverterImpl censusEntryConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @Mock
    private Model modelMock;

    @Before
    public void setUp() {
        censusEntryController = new CensusEntryFormControllerImpl(censusEntryServiceMock,
                censusServiceMock,
                censusEntryCommandConverterMock,
                censusEntryConverterMock,
                personServiceMock,
                capitalisationMock);
    }

    @Test
    public void getNewCensusEntryTest() {
        Model model = new ExtendedModelMap();
        assertEquals("censusentry/form", censusEntryController.getNewCensusEntry(model));
        assertEquals(CensusEntryCommand.class, Objects.requireNonNull(model.getAttribute(AttributeConstants.CENSUSENTRY_COMMAND)).getClass());
    }

    @Test
    public void censusEntryEditEditTest() {
        Long id = GetRandomLong();
        CensusEntry censusEntry = GetRandomCensusEntry();
        CensusEntryCommand censusEntryCommand = GetRandomCensusEntryCommand();
        when(censusEntryServiceMock.findById(id)).thenReturn(censusEntry);
        when(censusEntryConverterMock.convert(censusEntry)).thenReturn(censusEntryCommand);


        assertEquals("censusentry/form", censusEntryController.censusEntryEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.CENSUSENTRY_COMMAND, censusEntryCommand);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        CensusEntry censusEntry = GetRandomCensusEntry();
        CensusEntryCommand censusEntryCommand = GetRandomCensusEntryCommand();

        when(censusEntryServiceMock.findById(id)).thenReturn(censusEntry);
        when(censusEntryConverterMock.convert(censusEntry)).thenReturn(censusEntryCommand);
        assertEquals("censusentry/form", censusEntryController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.CENSUSENTRY_COMMAND, censusEntryCommand);
    }
}


