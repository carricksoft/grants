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
import scot.carricksoftware.grants.commands.images.AppendixImageCommandImpl;
import scot.carricksoftware.grants.controllers.images.appendixImages.AppendixImageFormControllerImpl;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageConverterImpl;
import scot.carricksoftware.grants.services.images.appendiximage.AppendixImageService;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.AppendixImageCommandValidatorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AppendixImageFormControllerSaveOrUpdateTest {
    
    private AppendixImageFormControllerImpl appendixImageController;

    @Mock
    private AppendixImageService appendixImageServiceMock;

    @Mock
    private AppendixImageCommandConverterImpl appendixImageCommandConverterMock;

    @Mock
    private AppendixImageConverterImpl appendixImageConverterMock;

    @Mock
    private ImageService imageServiceMock;

    @Mock
    private CapitaliseAppendixImageCommand capitaliseAppendixImageCommandMock;

    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    private AppendixImageCommandValidatorImpl appendixImageCommandValidatorImplMock;

    private AppendixImageCommand appendixImageCommand;


    @BeforeEach
    public void setUp() {
        appendixImageController = new AppendixImageFormControllerImpl(appendixImageServiceMock,
                appendixImageCommandConverterMock,
                appendixImageConverterMock,
                appendixImageCommandValidatorImplMock,
                imageServiceMock,
                capitaliseAppendixImageCommandMock);
        appendixImageCommand = new AppendixImageCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        appendixImageCommand.setId(id);
        when(appendixImageServiceMock.saveAppendixImageCommand(any(AppendixImageCommand.class))).thenReturn(appendixImageCommand);
        assertEquals("redirect:/appendixImage/4/show", appendixImageController.saveOrUpdate(appendixImageCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        appendixImageCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("images/appendixImage/form", appendixImageController.saveOrUpdate(appendixImageCommand, bindingResultMock, modelMock));
    }

}