/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.appendiximage;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageConverterImpl;
import scot.carricksoftware.grants.domains.images.AppendixImage;
import scot.carricksoftware.grants.repositories.images.AppendixImageRepository;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class AppendixImageServiceTest {

    AppendixImageService appendixImageService;

    @Mock
    AppendixImageRepository appendixImageRepositoryMock;

    @Mock
    AppendixImageConverterImpl appendixImageConverterImplMock;

    @Mock
    AppendixImageCommandConverterImpl appendixImageCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        appendixImageService = new AppendixImageServiceImpl(appendixImageRepositoryMock,
                appendixImageConverterImplMock,
                appendixImageCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;

    @Mock
    Page<AppendixImage> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        appendixImageService.deleteById(id);
        verify(appendixImageRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(appendixImageRepositoryMock.count()).thenReturn(result);
        assertEquals(result, appendixImageService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<AppendixImage> result = new ArrayList<>();
        AppendixImage appendixImage = new AppendixImage();
        result.add(appendixImage);
        when(pageMock.getContent()).thenReturn(result);
        when(appendixImageRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, appendixImageService.getPagedAppendixImages(0));
    }


}