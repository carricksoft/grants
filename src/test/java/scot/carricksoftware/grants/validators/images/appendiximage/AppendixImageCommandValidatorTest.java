/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.images.appendiximage;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;
import scot.carricksoftware.grants.validators.images.AppendixImageCommandValidator;
import scot.carricksoftware.grants.validators.images.AppendixImageCommandValidatorImpl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;


@ExtendWith(MockitoExtension.class)
class AppendixImageCommandValidatorTest {

    private AppendixImageCommandValidator validator;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock
    private AppendixImageCommand appendixImageCommandMock;

    @BeforeEach
    void setUp() {
        validator = new AppendixImageCommandValidatorImpl(validateTypesMock);
    }

    @Test
    void validateImageIsRunTest() {
        Image image = new Image();
        when(appendixImageCommandMock.getImage()).thenReturn(image);
        validator.validate(appendixImageCommandMock, bindingResultMock);

        verify(validateTypesMock).validateImage(image,
                "image", "The image cannot be null.", bindingResultMock);
    }

    @Test
    void validateOrderIsRunTest() {
        String order = GetRandomString();
        when(appendixImageCommandMock.getOrder()).thenReturn(order);
        validator.validate(appendixImageCommandMock, bindingResultMock);

        verify(validateTypesMock).validateNonNegativeInteger(order,
                "order", "Order must exist.", "The order must be an integer.",
                "The order must be non-negative.", bindingResultMock);
    }

    @Test
    void validateLevelIsRunTest() {
        String level = GetRandomString();
        when(appendixImageCommandMock.getLevel()).thenReturn(level);
        validator.validate(appendixImageCommandMock, bindingResultMock);

        verify(validateTypesMock).validateNonNegativeStaredInteger(level,
                "level", "Level must exist.", "Level must be an integer.",
                "The level must be non-negative.", bindingResultMock);
    }


}