/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.appendiximages;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.capitalisation.images.appendiximage.CapitaliseAppendixImageCommand;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;
import scot.carricksoftware.grants.commands.images.AppendixImageCommandImpl;
import scot.carricksoftware.grants.constants.ImageAttributeConstants;
import scot.carricksoftware.grants.controllers.images.appendixImages.AppendixImageFormControllerImpl;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageConverterImpl;
import scot.carricksoftware.grants.domains.images.AppendixImage;
import scot.carricksoftware.grants.services.images.appendiximage.AppendixImageService;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.AppendixImageCommandValidatorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class AppendixImageFormControllerTest {
    
    private AppendixImageFormControllerImpl appendixImageController;

    @Mock
    private AppendixImageService appendixImageServiceMock;

    @Mock
    private AppendixImageCommandConverterImpl appendixImageCommandConverterMock;

    @Mock
    private AppendixImageConverterImpl appendixImageConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private AppendixImageCommandValidatorImpl appendixImageCommandValidatorImplMock;

    @Mock
    private ImageService imageServiceMock;

    @Mock
    private CapitaliseAppendixImageCommand capitaliseAppendixImageCommandMock;


    @BeforeEach
    public void setUp() {
        appendixImageController = new AppendixImageFormControllerImpl(appendixImageServiceMock,
                appendixImageCommandConverterMock,
                appendixImageConverterMock,
                appendixImageCommandValidatorImplMock,
                imageServiceMock,
                capitaliseAppendixImageCommandMock);
    }

    @Test
    public void getNewAppendixImageTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("images/appendixImage/form", appendixImageController.getNewAppendixImage(modelMock));
        verify(modelMock, atLeast(2)).addAttribute(stringCaptor.capture(), objectCaptor.capture());

        boolean foundAppendixImageCommand = false;

        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("appendixImageCommand")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("AppendixImageCommandImpl")) {
                    foundAppendixImageCommand = true;
                }
            }
        }
        assertTrue(foundAppendixImageCommand);
    }

    @Test
    public void appendixImageEditTestEditTest() {
        Long id = GetRandomLong();
        AppendixImage appendixImage = new AppendixImage();
        when(appendixImageServiceMock.findById(id)).thenReturn(appendixImage);

        assertEquals("images/appendixImage/form", appendixImageController.appendixImageEdit(id + "", modelMock));
        verify(modelMock).addAttribute(ImageAttributeConstants.APPENDIX_IMAGE_COMMAND, appendixImage);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        AppendixImage appendixImage = new AppendixImage();
        AppendixImageCommand appendixImageCommand = new AppendixImageCommandImpl();

        when(appendixImageServiceMock.findById(id)).thenReturn(appendixImage);
        when(appendixImageConverterMock.convert(appendixImage)).thenReturn(appendixImageCommand);
        assertEquals("images/appendixImage/form", appendixImageController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(ImageAttributeConstants.APPENDIX_IMAGE_COMMAND, appendixImageCommand);
    }

}