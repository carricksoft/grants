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
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageConverterImpl;
import scot.carricksoftware.grants.domains.images.AppendixImage;
import scot.carricksoftware.grants.repositories.images.AppendixImageRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@ExtendWith(MockitoExtension.class)
public class AppendixImageServiceFindTest {

    AppendixImageService appendixImageService;

    @Mock
    AppendixImageRepository appendixImageRepositoryMock;

    @Mock
    AppendixImageConverterImpl appendixImageConverterMock;

    @Mock
    AppendixImageCommandConverterImpl appendixImageCommandConverterMock;

    @BeforeEach
    public void setUp() {
        appendixImageService = new AppendixImageServiceImpl(appendixImageRepositoryMock,
                appendixImageConverterMock,
                appendixImageCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<AppendixImage> countries = new ArrayList<>();
        countries.add(new AppendixImage());
        when(appendixImageRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, appendixImageService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        AppendixImage appendixImage = new AppendixImage();
        Optional<AppendixImage> appendixImageOptional = Optional.of(appendixImage);
        when(appendixImageRepositoryMock.findById(id)).thenReturn(appendixImageOptional);
        assertEquals(appendixImage, appendixImageService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<AppendixImage> empty = Optional.empty();
        when(appendixImageRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(appendixImageService.findById(id));
    }

}