/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.censuses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.controllers.census.CensusFormControllerImpl;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.census.CensusCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.CensusConverterImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.places.PlaceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCensusCommand;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;


@SpringBootTest
class CensusFormControllerTest {

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
    private Model modelMock;

    @BeforeEach
    void setUp() {
        censusController = new CensusFormControllerImpl(censusServiceMock,
                censusCommandConverterMock,
                censusConverterMock,
                placeServiceMock,
                capitalisationMock);
    }

    @Test
    void getNewCensusTest() {
        Model model = new ExtendedModelMap();
        assertEquals("census/form", censusController.getNewCensus(model));
        assertEquals(CensusCommand.class, Objects.requireNonNull(model.getAttribute(AttributeConstants.CENSUS_COMMAND)).getClass());
    }

    @Test
    void censusEditTestEditTest() {
        Long id = GetRandomLong();
        Census census = GetRandomCensus();
        CensusCommand censusCommand = GetRandomCensusCommand();
        List<Place> placeList = new ArrayList<>();
        placeList.add(GetRandomPlace());

        when(censusServiceMock.findById(id)).thenReturn(census);
        when(placeServiceMock.findAll()).thenReturn(placeList);
        when(censusConverterMock.convert(census)).thenReturn(censusCommand);

        assertEquals("census/form", censusController.censusEdit(id + "", modelMock));
        verify(modelMock).addAttribute("censusCommand", censusCommand);
        verify(modelMock).addAttribute("places", placeList);
    }

    @Test
    void showByIdTest() {
        Long id = GetRandomLong();
        Census census = GetRandomCensus();
        CensusCommand censusCommand = GetRandomCensusCommand();

        when(censusServiceMock.findById(id)).thenReturn(census);
        when(censusConverterMock.convert(census)).thenReturn(censusCommand);
        assertEquals("census/form", censusController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.CENSUS_COMMAND, censusCommand);
    }


}