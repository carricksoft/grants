/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 14:31. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.images;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;


@ExtendWith(MockitoExtension.class)
class ImageCommandValidatorTest {

    private ImageCommandValidator validator;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock
    private ImageCommand imageCommandMock;

    @BeforeEach
    void setUp() {
        validator = new ImageCommandValidatorImpl(validateTypesMock);
    }

    @Test
    void validateFileTypeIsRunTest() {
        String fileName = GetRandomString();
        when(imageCommandMock.getFileName()).thenReturn(fileName);
        validator.validate(imageCommandMock, bindingResultMock);

        verify(validateTypesMock).validateFileType(fileName,
                "fileName", new String[]{"JPG", "GIF"},
                "The file type is not supported.", bindingResultMock);
    }

    @Test
    void validateNameTypeIsRunTest() {
        String name = GetRandomString();
        when(imageCommandMock.getName()).thenReturn(name);
        validator.validate(imageCommandMock, bindingResultMock);

        verify(validateTypesMock).validateNullOrEmptyString(name,
                "name",
                "The name cannot be null.", bindingResultMock);
    }

    @Test
    void validateImageDataIsRunTest() {
        String fileName = GetRandomString();
        when(imageCommandMock.getFileName()).thenReturn(fileName);
        validator.validate(imageCommandMock, bindingResultMock);

        verify(validateTypesMock).validateNullOrEmptyString(fileName,
                "fileName",
                "The file to upload cannot be null.", bindingResultMock);
    }


}