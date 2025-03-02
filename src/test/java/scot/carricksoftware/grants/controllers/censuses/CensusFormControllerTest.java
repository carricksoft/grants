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
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.controllers.census.CensusFormControllerImpl;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.census.census.CensusCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.census.CensusConverterImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.places.PlaceService;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCensusCommand;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CensusFormControllerTest {

    @SuppressWarnings("unused")
    private CensusFormControllerImpl censusController;


    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    private CensusCommandConverterImpl censusCommandConverterMock;

    @Mock
    private CensusConverterImpl censusConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @Mock
    private Model modelMock;

    @Before
    public void setUp() {
        censusController = new CensusFormControllerImpl(censusServiceMock,
                censusCommandConverterMock,
                censusConverterMock,
                placeServiceMock,
                capitalisationMock);
    }

    @Test
    public void getNewCensusTest() {
        Model model = new ExtendedModelMap();
        assertEquals("census/form", censusController.getNewCensus(model));
        assertEquals(CensusCommand.class, Objects.requireNonNull(model.getAttribute(AttributeConstants.CENSUS_COMMAND)).getClass());
    }

    @Test
    public void censusEditEditTest() {
        Long id = GetRandomLong();
        Census census = GetRandomCensus();
        CensusCommand censusCommand = GetRandomCensusCommand();
        when(censusServiceMock.findById(id)).thenReturn(census);
        when(censusConverterMock.convert(census)).thenReturn(censusCommand);


        assertEquals("census/form", censusController.censusEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.CENSUS_COMMAND, censusCommand);
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


