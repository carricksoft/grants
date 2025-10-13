/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.domains.images.Image;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class ValidateTypesImageTest {

    private ValidateTypes validateTypes;

    private String field;
    private String message;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validateTypes = new ValidateTypesImpl();
        field = "field";
        message = "message";
    }

    @Test
    void imageNullTest() {
        validateTypes.validateImage(null, field, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, "", null, message);
    }

    @Test
    void imageNonNullTest() {
        validateTypes.validateImage(new Image(), field, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }


}