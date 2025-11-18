/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.documentimages;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import scot.carricksoftware.grants.capitalisation.images.documentimage.CapitaliseDocumentImageCommand;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.controllers.images.documentImages.DocumentImageFormControllerImpl;
import scot.carricksoftware.grants.converters.images.documentimage.DocumentImageConverterImpl;
import scot.carricksoftware.grants.services.images.documentimage.DocumentImageService;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.DocumentImageCommandValidatorImpl;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DocumentImageFormControllerValidationTest {
    
    private DocumentImageFormControllerImpl documentImageController;

    @Mock
    private DocumentImageService documentImageServiceMock;


    @Mock
    private DocumentImageConverterImpl documentImageConverterMock;

    @Mock
    private DocumentImageCommand documentImageCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private ImageService imageServiceMocK;

    @Mock
    private DocumentImageCommandValidatorImpl documentImageCommandValidatorMock;

    @Mock
    private CapitaliseDocumentImageCommand capitaliseDocumentImageCommandMock;

    @Mock
    Model modelMock;

    @BeforeEach
    public void setUp() {
        documentImageController = new DocumentImageFormControllerImpl(
                documentImageServiceMock,
                documentImageConverterMock,
                documentImageCommandValidatorMock,
                imageServiceMocK,
                capitaliseDocumentImageCommandMock);
    }


    @Test
    public void saveOrUpdateValidationTest() {
        when(documentImageServiceMock.saveDocumentImageCommand(any())).thenReturn(documentImageCommandMock);
        documentImageController.saveOrUpdate(documentImageCommandMock, bindingResultMock, modelMock);
        verify(documentImageCommandValidatorMock).validate(documentImageCommandMock, bindingResultMock);
    }

    @Test
    public void saveOrUpdateCapitalisationTest() {
        when(documentImageServiceMock.saveDocumentImageCommand(any())).thenReturn(documentImageCommandMock);
        documentImageController.saveOrUpdate(documentImageCommandMock, bindingResultMock, modelMock);
        verify(capitaliseDocumentImageCommandMock).capitalise(documentImageCommandMock);
    }

}