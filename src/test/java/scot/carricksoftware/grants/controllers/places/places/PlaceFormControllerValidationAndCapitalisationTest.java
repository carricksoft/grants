/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.places;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.capitalisation.places.places.CapitalisePlace;
import scot.carricksoftware.grants.commands.places.places.PlaceCommand;
import scot.carricksoftware.grants.commands.places.places.PlaceCommandImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.services.places.regions.RegionService;
import scot.carricksoftware.grants.validators.places.PlaceCommandValidator;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PlaceFormControllerValidationAndCapitalisationTest {

    @SuppressWarnings({"unused"})
    private PlaceFormControllerImpl placeController;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private RegionService regionServiceMock;

    @Mock
    private PlaceCommandConverterImpl placeCommandConverterMock;

    @Mock
    private PlaceConverterImpl placeConverterMock;

    @Mock
    private CapitalisePlace capitalisePlaceMock;

    @Mock
    private PlaceCommandValidator placeCommandValidatorMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    Model modelMock;

    PlaceCommand placeCommand;

    @BeforeEach
    public void setUp() {
        placeController = new PlaceFormControllerImpl(placeServiceMock,
                placeCommandConverterMock,
                placeConverterMock,
                capitalisePlaceMock,
                placeCommandValidatorMock,
                regionServiceMock);
        placeCommand = new PlaceCommandImpl();
    }

    @Test
    public void validationTakesPlaceTest() {
        when(placeServiceMock.savePlaceCommand(placeCommand)).thenReturn(placeCommand);
        placeController.saveOrUpdate(placeCommand, bindingResultMock, modelMock);
        verify(placeCommandValidatorMock).validate(placeCommand, bindingResultMock);
    }

    @Test
    public void capitalisationTakesPlaceTest() {
        when(placeServiceMock.savePlaceCommand(placeCommand)).thenReturn(placeCommand);
        placeController.saveOrUpdate(placeCommand, bindingResultMock, modelMock);
        verify(capitalisePlaceMock).capitalise(placeCommand);
    }
}