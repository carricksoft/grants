/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 16:14. All rights reserved.
 *
 */

package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.services.images.appendiximage.AppendixImageService;
import scot.carricksoftware.grants.services.images.documentimage.DocumentImageService;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.services.images.personimage.PersonImageService;
import scot.carricksoftware.grants.services.images.placeimage.PlaceImageService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DataLoadImagesImageAppendixAndDocumentTest {

    private DataLoadImages dataLoadImages;

    @Mock
    private ImageService imageServiceMock;

    @Mock
    private PersonImageService personImageServiceMock;

    @Mock
    private PlaceImageService placeImageServiceMock;

    @Mock
    private AppendixImageService appendixImageServiceMock;

    @Mock
    private DocumentImageService documentImageServiceMock;

    @Mock
    private PlaceService placeServiceMock;


    @BeforeEach
    void setUp() {
        dataLoadImages = new DataLoadImages(imageServiceMock,
                personImageServiceMock,
                placeImageServiceMock,
                appendixImageServiceMock,
                documentImageServiceMock,
                placeServiceMock);
    }


    @Test
    public void anAppendixImageIsCreatedTest() {
        ArgumentCaptor<AppendixImageCommand> captor = ArgumentCaptor.forClass(AppendixImageCommand.class);
        Image image = new Image();

        when(imageServiceMock.findById(1L)).thenReturn(image);
        dataLoadImages.load();

        verify(appendixImageServiceMock).saveAppendixImageCommand(captor.capture());
        assertEquals(image, captor.getValue().getImage());
        assertEquals("Appendix caption", captor.getValue().getCaption());
    }

    @Test
    public void aDocumentImageIsCreatedTest() {
        ArgumentCaptor<DocumentImageCommand> captor = ArgumentCaptor.forClass(DocumentImageCommand.class);
        Image image = new Image();

        when(imageServiceMock.findById(1L)).thenReturn(image);
        dataLoadImages.load();

        verify(documentImageServiceMock).saveDocumentImageCommand(captor.capture());
        assertEquals(image, captor.getValue().getImage());
        assertEquals("Document caption", captor.getValue().getCaption());
    }


}