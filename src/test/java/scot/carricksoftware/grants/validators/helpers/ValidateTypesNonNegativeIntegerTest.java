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


@ExtendWith(MockitoExtension.class)
class ValidateTypesNonNegativeIntegerTest {

    private ValidateTypes validateTypes;

    private String field;
    private String nullMessage;
    private String formatMessage;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validateTypes = new ValidateTypesImpl();
        field = "field";
        nullMessage = "null-message";
        formatMessage = "format-message";
    }

    @Test
    void invalidIntegerTest() {
        validateTypes.validateNonNegativeInteger("ccc", field, nullMessage, formatMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, formatMessage);
    }

    @Test
    void validIntegerTest() {
        validateTypes.validateNonNegativeInteger("15", field, nullMessage, formatMessage, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void realTest() {
        validateTypes.validateNonNegativeInteger("3.14", field, nullMessage, formatMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, formatMessage);
    }

    @Test
    void zeroTest() {
        validateTypes.validateNonNegativeInteger("0", field, nullMessage, formatMessage, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void negativeTest() {
        validateTypes.validateNonNegativeInteger("-1", field, nullMessage, formatMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, formatMessage);
    }

    @Test
    void nullTest() {
        validateTypes.validateNonNegativeInteger(null, field, nullMessage, formatMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, nullMessage);
    }

    @Test
    void emptyTest() {
        validateTypes.validateNonNegativeInteger("", field, nullMessage, formatMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, nullMessage);
    }

}