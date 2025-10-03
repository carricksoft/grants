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
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.commands.images.ImageCommandImpl;
import scot.carricksoftware.grants.converters.images.ConvertToBase64;
import scot.carricksoftware.grants.converters.images.image.ImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.image.ImageConverterImpl;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.ImageCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class ImageFormShowByIdTest {

    @SuppressWarnings("unused")
    private ImageFormControllerImpl imageController;

    @Mock
    private ImageService imageServiceMock;

    @Mock
    private ImageCommandConverterImpl imageCommandConverterMock;

    @Mock
    private ImageConverterImpl imageConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private ConvertToBase64 convertToBase64Mock;

    @Mock
    private ImageCommandValidator imageCommandValidatorMock;


    @BeforeEach
    public void setUp() {
        imageController = new ImageFormControllerImpl(imageServiceMock,
                imageCommandConverterMock,
                imageConverterMock,
                imageCommandValidatorMock,
                convertToBase64Mock);
    }

    @Test
    public void returnTest() {
        assertEquals("images/image/form", imageController.showById(GetRandomLong().toString(), modelMock));
    }

    @Test
    public void attributeIsAddedTest() {
        ImageCommand imageCommand = new ImageCommandImpl();
        when(imageConverterMock.convert(any())).thenReturn(imageCommand);

        imageController.showById(GetRandomLong().toString(), modelMock);
        verify(modelMock).addAttribute("imageCommand", imageCommand);
    }
}