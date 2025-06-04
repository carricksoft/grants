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
import scot.carricksoftware.grants.constants.ApplicationConstants;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;


@ExtendWith(MockitoExtension.class)
class ValidateTypesNullOrEmptyTest {

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
    void nullTest() {
        validateTypes.validateNullOrEmptyString(null, field, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void emptyTest() {
        validateTypes.validateNullOrEmptyString(" ", field, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void nonNullTest() {
        validateTypes.validateNullOrEmptyString(GetRandomString(), field, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }


}