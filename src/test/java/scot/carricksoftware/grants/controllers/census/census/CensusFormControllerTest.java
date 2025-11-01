/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:30. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.census;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.capitalisation.census.census.CapitaliseCensusCommand;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.census.CensusConverterImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.services.census.census.CensusService;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.validators.census.census.CensusCommandValidatorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusCommand;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class CensusFormControllerTest {

    @SuppressWarnings("unused")
    private CensusFormControllerImpl censusController;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private CensusConverterImpl censusConverterMock;


    @Mock
    private Model modelMock;

    @Mock
    CensusCommandValidatorImpl censusCommandValidatorImplMock;

    @Mock
    CapitaliseCensusCommand capitaliseCensusCommandMock;

    @BeforeEach
    public void setUp() {
        censusController = new CensusFormControllerImpl(censusServiceMock,
                censusCommandValidatorImplMock,
                capitaliseCensusCommandMock,
                censusConverterMock,
                placeServiceMock);
    }

    @Test
    public void getNewCensusTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("census/form", censusController.getNewCensus(modelMock));
        verify(modelMock, atLeast(1)).addAttribute(stringCaptor.capture(), objectCaptor.capture());

        boolean foundCensusCommand = false;
        boolean foundPlaces = false;
        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("places")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("LinkedList")) {
                    foundPlaces = true;
                }
            }
            if (stringCaptor.getAllValues().get(i).equals("censusCommand")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("CensusCommandImpl")) {
                    foundCensusCommand = true;
                }
            }
        }

        assertTrue(foundPlaces && foundCensusCommand);
    }

    @Test
    public void censusEditTestEditTest() {
        Long id = GetRandomLong();
        Census census = GetRandomCensus();
        when(censusServiceMock.findById(id)).thenReturn(census);

        assertEquals("census/form", censusController.censusEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.CENSUS_COMMAND, census);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        Census census = GetRandomCensus();
        CensusCommand censusCommand = GetRandomCensusCommand();

        when(censusServiceMock.findById(id)).thenReturn(census);
        when(censusConverterMock.convert(census)).thenReturn(censusCommand);
        assertEquals("census/form", censusController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.CENSUS_COMMAND, censusCommand);
    }

}