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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.images.documentimage.DocumentImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.documentimage.DocumentImageConverterImpl;
import scot.carricksoftware.grants.domains.images.DocumentImage;
import scot.carricksoftware.grants.repositories.images.DocumentImageRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class DocumentImageServiceTest {

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

    @Mock
    Page<DocumentImage> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        documentImageService.deleteById(id);
        verify(documentImageRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(documentImageRepositoryMock.count()).thenReturn(result);
        assertEquals(result, documentImageService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<DocumentImage> result = new ArrayList<>();
        DocumentImage documentImage = new DocumentImage();
        result.add(documentImage);
        when(pageMock.getContent()).thenReturn(result);
        when(documentImageRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, documentImageService.getPagedDocumentImages(0));
    }


}