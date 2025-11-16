/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.documentimage;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.commands.images.DocumentImageCommandImpl;
import scot.carricksoftware.grants.converters.images.documentimage.DocumentImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.documentimage.DocumentImageConverterImpl;
import scot.carricksoftware.grants.domains.images.DocumentImage;
import scot.carricksoftware.grants.repositories.images.DocumentImageRepository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DocumentImageServiceSaveTest {

    DocumentImageService documentImageService;

    @Mock
    DocumentImageRepository documentImageRepositoryMock;

    @Mock
    DocumentImageConverterImpl documentImageConverterImplMock;

    @Mock
    DocumentImageCommandConverterImpl documentImageCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        documentImageService = new DocumentImageServiceImpl(documentImageRepositoryMock,
                documentImageConverterImplMock,
                documentImageCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @Test
    public void saveTest() {
        DocumentImage documentImage = new DocumentImage();

        when(documentImageRepositoryMock.save(documentImage)).thenReturn(documentImage);

        assertEquals(documentImage, documentImageService.save(documentImage));
    }

    @Test
    public void saveDocumentImageCommandTest() {
        DocumentImage documentImage = new DocumentImage();
        DocumentImageCommand documentImageCommand = new DocumentImageCommandImpl();
        when(documentImageCommandConverterImplMock.convert(documentImageCommand)).thenReturn(documentImage);
        when(documentImageRepositoryMock.save(documentImage)).thenReturn(documentImage);
        when(documentImageConverterImplMock.convert((documentImage))).thenReturn(documentImageCommand);

        assertEquals(documentImageCommand, documentImageService.saveDocumentImageCommand(documentImageCommand));
    }


}