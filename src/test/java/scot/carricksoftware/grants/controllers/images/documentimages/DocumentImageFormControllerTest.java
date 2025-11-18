/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.documentimages;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.capitalisation.images.documentimage.CapitaliseDocumentImageCommand;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.commands.images.DocumentImageCommandImpl;
import scot.carricksoftware.grants.constants.ImageAttributeConstants;
import scot.carricksoftware.grants.controllers.images.documentImages.DocumentImageFormController;
import scot.carricksoftware.grants.controllers.images.documentImages.DocumentImageFormControllerImpl;
import scot.carricksoftware.grants.converters.images.documentimage.DocumentImageConverter;
import scot.carricksoftware.grants.domains.images.DocumentImage;
import scot.carricksoftware.grants.services.images.documentimage.DocumentImageService;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.DocumentImageCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class DocumentImageFormControllerTest {
    
    private DocumentImageFormController documentImageFormController;

    @Mock
    private DocumentImageService documentImageServiceMock;


    @Mock
    private DocumentImageConverter documentImageConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private DocumentImageCommandValidator documentImageCommandValidatorMock;

    @Mock
    private ImageService imageServiceMock;

    @Mock
    private CapitaliseDocumentImageCommand capitaliseDocumentImageCommandMock;


    @BeforeEach
    public void setUp() {
        documentImageFormController= new DocumentImageFormControllerImpl(
                documentImageServiceMock,
                documentImageConverterMock,
                documentImageCommandValidatorMock,
                imageServiceMock,
                capitaliseDocumentImageCommandMock);
    }

    @Test
    public void getNewDocumentImageTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("images/documentImage/form", documentImageFormController.getNewDocumentImage(modelMock));
        verify(modelMock, atLeast(2)).addAttribute(stringCaptor.capture(), objectCaptor.capture());

        boolean foundDocumentImageCommand = false;

        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("documentImageCommand")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("DocumentImageCommandImpl")) {
                    foundDocumentImageCommand = true;
                }
            }
        }
        assertTrue(foundDocumentImageCommand);
    }

    @Test
    public void documentImageEditTestEditTest() {
        Long id = GetRandomLong();
        DocumentImage documentImage = new DocumentImage();
        when(documentImageServiceMock.findById(id)).thenReturn(documentImage);

        assertEquals("images/documentImage/form", documentImageFormController.documentImageEdit(id + "", modelMock));
        verify(modelMock).addAttribute(ImageAttributeConstants.DOCUMENT_IMAGE_COMMAND, documentImage);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        DocumentImage documentImage = new DocumentImage();
        DocumentImageCommand documentImageCommand = new DocumentImageCommandImpl();

        when(documentImageServiceMock.findById(id)).thenReturn(documentImage);
        when(documentImageConverterMock.convert(documentImage)).thenReturn(documentImageCommand);
        assertEquals("images/documentImage/form", documentImageFormController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(ImageAttributeConstants.DOCUMENT_IMAGE_COMMAND, documentImageCommand);
    }

}