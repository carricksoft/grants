/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.PlaceCommand;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.services.places.CountryService;
import scot.carricksoftware.grants.services.places.PlaceService;
import scot.carricksoftware.grants.services.places.RegionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class PlaceFormControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private PlaceFormControllerImpl placeController;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private CountryService countryServiceMock;

    @Mock
    private RegionService regionServiceMock;

    @Mock
    private PlaceCommandConverterImpl placeCommandConverterMock;

    @Mock
    private PlaceConverterImpl placeConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;


    @Mock
    BindingResult bindingResultMock;


    @BeforeEach
    void setUp() {
        placeController = new PlaceFormControllerImpl(placeServiceMock,
                placeCommandConverterMock,
                placeConverterMock,
                capitalisationMock,
                countryServiceMock,
                regionServiceMock);
    }

    @Test
    void saveOrUpdateNoErrorsTest() {
        PlaceCommand placeCommand = new PlaceCommand();
        Long id = 4L;
        placeCommand.setId(id);
        when(placeServiceMock.savePlaceCommand(any(PlaceCommand.class))).thenReturn(placeCommand);
        assertEquals("redirect:/place/4/show", placeController.saveOrUpdate(placeCommand, bindingResultMock));
    }

    @Test
    void saveOrUpdateErrorsTest() {
        PlaceCommand placeCommand = new PlaceCommand();
        Long id = 4L;
        placeCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        when(placeServiceMock.savePlaceCommand(any(PlaceCommand.class))).thenReturn(placeCommand);
        assertEquals("place/form", placeController.saveOrUpdate(placeCommand, bindingResultMock));
    }

    @Test
    void CleaningTakesPlaceTest() {
        PlaceCommand placeCommand = new PlaceCommand();
        placeCommand.setId(4L);
        placeCommand.setName("england");
        when(bindingResultMock.hasErrors()).thenReturn(false);
        when(placeServiceMock.savePlaceCommand(any(PlaceCommand.class))).thenReturn(placeCommand);
        placeController.saveOrUpdate(placeCommand, bindingResultMock);
        verify(capitalisationMock).getCapitalisation("england");
    }


}