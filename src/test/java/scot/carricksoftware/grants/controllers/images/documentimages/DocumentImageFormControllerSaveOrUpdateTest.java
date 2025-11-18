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
import scot.carricksoftware.grants.commands.images.DocumentImageCommandImpl;
import scot.carricksoftware.grants.controllers.images.documentImages.DocumentImageFormController;
import scot.carricksoftware.grants.controllers.images.documentImages.DocumentImageFormControllerImpl;
import scot.carricksoftware.grants.converters.images.documentimage.DocumentImageConverter;
import scot.carricksoftware.grants.services.images.documentimage.DocumentImageService;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.DocumentImageCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DocumentImageFormControllerSaveOrUpdateTest {
    
    private DocumentImageFormController documentImageFormController;

    @Mock
    private DocumentImageService documentImageServiceMock;

    @Mock
    private DocumentImageConverter documentImageConverterMock;

    @Mock
    private ImageService imageServiceMock;

    @Mock
    private CapitaliseDocumentImageCommand capitaliseDocumentImageCommandMock;

    @Mock
    Model modelMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    private DocumentImageCommandValidator documentImageCommandValidatorMock;

    private DocumentImageCommand documentImageCommand;

    @BeforeEach
    public void setUp() {
        documentImageFormController= new DocumentImageFormControllerImpl(
                documentImageServiceMock,
                documentImageConverterMock,
                documentImageCommandValidatorMock,
                imageServiceMock,
                capitaliseDocumentImageCommandMock);
        documentImageCommand = new DocumentImageCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        documentImageCommand.setId(id);
        when(documentImageServiceMock.saveDocumentImageCommand(any(DocumentImageCommand.class))).thenReturn(documentImageCommand);
        assertEquals("redirect:/documentImage/4/show", documentImageFormController.saveOrUpdate(documentImageCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        documentImageCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("images/documentImage/form", documentImageFormController.saveOrUpdate(documentImageCommand, bindingResultMock, modelMock));
    }

}