/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.images;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.converters.images.ConvertToBase64;
import scot.carricksoftware.grants.converters.images.image.ImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.image.ImageConverterImpl;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.ImageCommandValidator;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;


@ExtendWith(MockitoExtension.class)
public class ImageFormControllerImageDataTest {

    private ImageFormControllerImpl imageController;

    @Mock
    private ImageService imageServiceMock;

    @Mock
    private ImageCommandConverterImpl imageCommandConverterMock;

    @Mock
    private ImageConverterImpl imageConverterMock;

    @Mock
    ImageCommandValidator imageCommandValidatorMock;

    @SuppressWarnings("unused")
    @Mock
    Model modelMock;

    @Mock
    ConvertToBase64 convertToBase64Mock;

    @Mock
    MultipartFile fileMock;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    ImageCommand imageCommandMock;

    @BeforeEach
    public void setUp() {
        imageController = new ImageFormControllerImpl(imageServiceMock,
                imageCommandConverterMock,
                imageConverterMock,
                imageCommandValidatorMock,
                convertToBase64Mock);
        when(imageServiceMock.saveImageCommand(any())).thenReturn(imageCommandMock);
    }

    @Test
    public void nullTest() throws IOException {
        imageController.saveOrUpdate(imageCommandMock, fileMock, bindingResultMock, modelMock);

        verify(imageCommandMock).setFileName(any());
        verify(imageCommandMock).setImageData(any());
    }

    @Test
    public void NonEmptyTest() throws IOException {
        when(imageCommandMock.getImageData()).thenReturn(GetRandomString());

        imageController.saveOrUpdate(imageCommandMock, fileMock, bindingResultMock, modelMock);
        verify(imageCommandMock, times(0)).setFileName(any());
        verify(imageCommandMock, times(0)).setImageData(any());
    }

    @Test
    public void emptyTest() throws IOException {
        when(imageCommandMock.getImageData()).thenReturn("");

        imageController.saveOrUpdate(imageCommandMock, fileMock, bindingResultMock, modelMock);
        verify(imageCommandMock).setFileName(any());
        verify(imageCommandMock).setImageData(any());
    }

}