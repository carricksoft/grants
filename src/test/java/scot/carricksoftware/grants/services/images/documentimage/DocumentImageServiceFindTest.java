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
import scot.carricksoftware.grants.converters.images.documentimage.DocumentImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.documentimage.DocumentImageConverterImpl;
import scot.carricksoftware.grants.domains.images.DocumentImage;
import scot.carricksoftware.grants.repositories.images.DocumentImageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
public class DocumentImageServiceFindTest {

    DocumentImageService documentImageService;

    @Mock
    DocumentImageRepository documentImageRepositoryMock;

    @Mock
    DocumentImageConverterImpl documentImageConverterMock;

    @Mock
    DocumentImageCommandConverterImpl documentImageCommandConverterMock;

    @BeforeEach
    public void setUp() {
        documentImageService = new DocumentImageServiceImpl(documentImageRepositoryMock,
                documentImageConverterMock,
                documentImageCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<DocumentImage> countries = new ArrayList<>();
        countries.add(new DocumentImage());
        when(documentImageRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, documentImageService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        DocumentImage documentImage = new DocumentImage();
        Optional<DocumentImage> documentImageOptional = Optional.of(documentImage);
        when(documentImageRepositoryMock.findById(id)).thenReturn(documentImageOptional);
        assertEquals(documentImage, documentImageService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<DocumentImage> empty = Optional.empty();
        when(documentImageRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(documentImageService.findById(id));
    }

}