/*
 * Copyright (c) 2025-2026.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.images.placeimage;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;
import scot.carricksoftware.grants.validators.images.PlaceImageCommandValidator;
import scot.carricksoftware.grants.validators.images.PlaceImageCommandValidatorImpl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;


@ExtendWith(MockitoExtension.class)
class PlaceImageCommandValidatorImageSizeTest {

    private PlaceImageCommandValidator validator;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock
    private PlaceImageCommand placeImageCommandMock;

    @BeforeEach
    void setUp() {
        validator = new PlaceImageCommandValidatorImpl(validateTypesMock);
    }

    @Test
    void validateHeightIsRunTest() {
        String height = GetRandomString();
        when(placeImageCommandMock.getHeight()).thenReturn(height);
        validator.validate(placeImageCommandMock, bindingResultMock);

        verify(validateTypesMock).validateIntegerRange(height,
                100, 10000,
                "height",
                "Height cannot be null.",
                "Height must be an integer.",
                "Height must be between 100 and 10000",
                bindingResultMock);
    }

    @Test
    void validateWidthIsRunTest() {
        String width = GetRandomString();
        when(placeImageCommandMock.getWidth()).thenReturn(width);
        validator.validate(placeImageCommandMock, bindingResultMock);

        verify(validateTypesMock).validateIntegerRange(width,
                100, 10000,
                "width",
                "Width cannot be null.",
                "Width must be an integer.",
                "Width must be between 100 and 10000",
                bindingResultMock);
    }



}