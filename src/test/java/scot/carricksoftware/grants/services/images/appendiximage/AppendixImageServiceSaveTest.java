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
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;
import scot.carricksoftware.grants.commands.images.AppendixImageCommandImpl;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageConverterImpl;
import scot.carricksoftware.grants.domains.images.AppendixImage;
import scot.carricksoftware.grants.repositories.images.AppendixImageRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AppendixImageServiceSaveTest {

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


    @Test
    public void saveTest() {
        AppendixImage appendixImage = new AppendixImage();

        when(appendixImageRepositoryMock.save(appendixImage)).thenReturn(appendixImage);

        assertEquals(appendixImage, appendixImageService.save(appendixImage));
    }

    @Test
    public void saveAppendixImageCommandTest() {
        AppendixImage appendixImage = new AppendixImage();
        AppendixImageCommand appendixImageCommand = new AppendixImageCommandImpl();
        when(appendixImageCommandConverterImplMock.convert(appendixImageCommand)).thenReturn(appendixImage);
        when(appendixImageRepositoryMock.save(appendixImage)).thenReturn(appendixImage);
        when(appendixImageConverterImplMock.convert((appendixImage))).thenReturn(appendixImageCommand);

        assertEquals(appendixImageCommand, appendixImageService.saveAppendixImageCommand(appendixImageCommand));
    }


}