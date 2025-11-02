/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.appendiximages;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.capitalisation.images.appendiximage.CapitaliseAppendixImageCommand;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;
import scot.carricksoftware.grants.controllers.images.appendixImages.AppendixImageFormControllerImpl;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageConverterImpl;
import scot.carricksoftware.grants.services.images.appendiximage.AppendixImageService;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.AppendixImageCommandValidatorImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AppendixImageFormControllerValidationTest {
    
    private AppendixImageFormControllerImpl appendixImageController;

    @Mock
    private AppendixImageService appendixImageServiceMock;

    @Mock
    private AppendixImageCommandConverterImpl appendixImageCommandConverterMock;

    @Mock
    private AppendixImageConverterImpl appendixImageConverterMock;

    @Mock
    private AppendixImageCommand appendixImageCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private ImageService imageServiceMocK;

    @Mock
    private AppendixImageCommandValidatorImpl appendixImageCommandValidatorImplMock;

    @Mock
    private CapitaliseAppendixImageCommand capitaliseAppendixImageCommandMock;

    @Mock
    Model modelMock;

    @BeforeEach
    public void setUp() {
        appendixImageController = new AppendixImageFormControllerImpl(appendixImageServiceMock,
                appendixImageCommandConverterMock,
                appendixImageConverterMock,
                appendixImageCommandValidatorImplMock,
                imageServiceMocK,
                capitaliseAppendixImageCommandMock);
    }


    @Test
    public void saveOrUpdateValidationTest() {
        when(appendixImageServiceMock.saveAppendixImageCommand(any())).thenReturn(appendixImageCommandMock);
        appendixImageController.saveOrUpdate(appendixImageCommandMock, bindingResultMock, modelMock);
        verify(appendixImageCommandValidatorImplMock).validate(appendixImageCommandMock, bindingResultMock);
    }

    @Test
    public void saveOrUpdateCapitalisationTest() {
        when(appendixImageServiceMock.saveAppendixImageCommand(any())).thenReturn(appendixImageCommandMock);
        appendixImageController.saveOrUpdate(appendixImageCommandMock, bindingResultMock, modelMock);
        verify(capitaliseAppendixImageCommandMock).capitalise(appendixImageCommandMock);
    }

}