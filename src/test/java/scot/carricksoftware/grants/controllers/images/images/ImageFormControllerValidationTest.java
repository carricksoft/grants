/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.images;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.converters.images.image.ImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.image.ImageConverterImpl;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.ImageCommandValidator;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
public class ImageFormControllerValidationTest {

    private ImageFormControllerImpl imageController;

    @Mock
    private ImageService imageServiceMock;

    @Mock
    private ImageCommandConverterImpl imageCommandConverterMock;

    @Mock
    private ImageConverterImpl imageConverterMock;


    @Mock
    ImageCommandValidator imageCommandValidatorMock;

    @SuppressWarnings("unused")
    @Mock
    Model modelMock;

    @BeforeEach
    public void setUp() {
        imageController = new ImageFormControllerImpl(imageServiceMock,
                imageCommandConverterMock,
                imageConverterMock,
                imageCommandValidatorMock);
    }

    @Test
    public void constructorTest() {
        assertNotNull(imageController);
    }


}