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
class ValidateTypesPastDateAndTimeTest {

    private ValidateTypes validateTypes;

    private String field;
    private String nullMessage;
    private String formatMessage;
    private String pastMessage;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validateTypes = new ValidateTypesImpl();
        field = "field";
        nullMessage = "null-message";
        formatMessage = "format-message";
        pastMessage = "past-message";
    }

    @Test
    void inValidTest() {
        validateTypes.validatePastDateAndTime("xx", field, nullMessage, formatMessage, pastMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, formatMessage);
    }

    @Test
    void validTest() {
        validateTypes.validatePastDateAndTime("25/01/1953 03:24", field, nullMessage, formatMessage, pastMessage, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void nullTest() {
        validateTypes.validatePastDateAndTime(null, field, nullMessage, formatMessage, pastMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, nullMessage);
    }

    @Test
    void emptyTest() {
        validateTypes.validatePastDateAndTime("  ", field, nullMessage, formatMessage, pastMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, nullMessage);
    }

    @Test
    void pastTest() {
        validateTypes.validatePastDateAndTime("25/01/2053 06:54", field, nullMessage, formatMessage, pastMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, pastMessage);
    }


}