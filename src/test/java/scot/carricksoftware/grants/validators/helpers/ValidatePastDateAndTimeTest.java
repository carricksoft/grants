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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;


@ExtendWith(MockitoExtension.class)
class ValidatePastDateAndTimeTest {
    private ValidateDateTypes validator;

    private String field;
    private String nullMessage;
    private String formatMessage;
    private String pastMessage;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new ValidateDateTypesImpl();
        field = "field";
        nullMessage = "null-message";
        formatMessage = "format-message";
        pastMessage = "past-message";
    }

    @Test
    void inValidTest() {
        validator.validatePastDateAndTime("xx", field, nullMessage, formatMessage, pastMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, "", null, formatMessage);
    }

    @Test
    void validTest() {
        validator.validatePastDateAndTime("25/01/1953 03:24", field, nullMessage, formatMessage, pastMessage, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void nullTest() {
        validator.validatePastDateAndTime(null, field, nullMessage, formatMessage, pastMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, "", null, nullMessage);
    }

    @Test
    void emptyTest() {
        validator.validatePastDateAndTime("  ", field, nullMessage, formatMessage, pastMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, "", null, nullMessage);
    }

    @Test
    void pastTest() {
        validator.validatePastDateAndTime("25/01/2053 06:54", field, nullMessage, formatMessage, pastMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, "", null, pastMessage);
    }


}