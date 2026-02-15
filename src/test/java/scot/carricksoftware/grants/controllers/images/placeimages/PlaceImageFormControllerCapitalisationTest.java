/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.placeimages;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.capitalisation.images.placeimage.CapitalisePlaceImageCommand;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.placeimage.PlaceImageConverterImpl;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.services.images.placeimage.PlaceImageService;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.validators.images.PlaceImageCommandValidator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PlaceImageFormControllerCapitalisationTest {

    @SuppressWarnings("unused")
    private PlaceImageFormControllerImpl placeImageController;

    @Mock
    private PlaceImageService placeImageServiceMock;

    @Mock
    private PlaceImageCommandConverterImpl placeImageCommandConverterMock;

    @Mock
    private PlaceImageConverterImpl placeImageConverterMock;


    @Mock
    private PlaceImageCommand placeImageCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private PlaceImageCommandValidator placeImageCommandValidatorMock;

    @Mock
    private CapitalisePlaceImageCommand capitalisePlaceImageCommandMock;

    @Mock
    private ImageService imageServiceMock;

    @Mock
    Model modelMock;


    @BeforeEach
    public void setUp() {
        placeImageController = new PlaceImageFormControllerImpl(placeImageServiceMock,
                placeImageCommandConverterMock,
                placeImageConverterMock,
                placeImageCommandValidatorMock,
                placeServiceMock,
                imageServiceMock,
                capitalisePlaceImageCommandMock);
    }


    @Test
    public void saveOrUpdateValidationTest() {
        when(placeImageServiceMock.savePlaceImageCommand(any())).thenReturn(placeImageCommandMock);
        placeImageController.saveOrUpdate(placeImageCommandMock, bindingResultMock, modelMock);
        verify(capitalisePlaceImageCommandMock).capitalise(placeImageCommandMock);
    }


}