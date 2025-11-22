/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.images.documentimage;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;
import scot.carricksoftware.grants.validators.images.DocumentImageCommandValidator;
import scot.carricksoftware.grants.validators.images.DocumentImageCommandValidatorImpl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;


@ExtendWith(MockitoExtension.class)
class DocumentImageCommandValidatorTest {

    private DocumentImageCommandValidator validator;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock
    private DocumentImageCommand documentImageCommandMock;

    @BeforeEach
    void setUp() {
        validator = new DocumentImageCommandValidatorImpl(validateTypesMock);
    }

    @Test
    void validateImageIsRunTest() {
        Image image = new Image();
        when(documentImageCommandMock.getImage()).thenReturn(image);
        validator.validate(documentImageCommandMock, bindingResultMock);

        verify(validateTypesMock).validateImage(image,
                "image", "The image cannot be null.", bindingResultMock);
    }

    @Test
    void validateOrderIsRunTest() {
        String order = GetRandomString();
        when(documentImageCommandMock.getOrder()).thenReturn(order);
        validator.validate(documentImageCommandMock, bindingResultMock);

        verify(validateTypesMock).validateNonNegativeInteger(order,
                "order", "Order must exist.", "The order must be an integer.",
                "The order must be non-negative.", bindingResultMock);
    }

    @Test
    void validateLevelIsRunTest() {
        String level = GetRandomString();
        when(documentImageCommandMock.getLevel()).thenReturn(level);
        validator.validate(documentImageCommandMock, bindingResultMock);

        verify(validateTypesMock).validateNonNegativeStaredInteger(level,
                "level", "Level must exist.", "Level must be an integer.",
                "The level must be non-negative.", bindingResultMock);
    }


}