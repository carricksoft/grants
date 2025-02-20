/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
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
import scot.carricksoftware.grants.services.places.PlaceService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class PlaceFormControllerCleansingTest {

    @SuppressWarnings("unused")
    private PlaceFormControllerImpl placeController;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private PlaceCommandConverterImpl placeCommandConverterMock;

    @Mock
    private PlaceConverterImpl placeConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @Mock
    private PlaceCommand placeCommandMock;

    @Mock
    private BindingResult bindingResultMock;


    @BeforeEach
    void setUp() {
        placeController = new PlaceFormControllerImpl(placeServiceMock,
                placeCommandConverterMock,
                placeConverterMock,
                capitalisationMock);
    }

    @Test
    void saveOrUpdateCleansingNameTest() {
        String name = "goat";
        String uName = "Goat";
        when(placeServiceMock.savePlaceCommand(any())).thenReturn(placeCommandMock);
        when(placeCommandMock.getName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        placeController.saveOrUpdate(placeCommandMock, bindingResultMock);

        verify(placeCommandMock).setName(uName);
    }


}