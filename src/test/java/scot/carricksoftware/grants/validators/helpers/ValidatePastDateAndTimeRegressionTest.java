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

import static org.mockito.Mockito.verifyNoInteractions;


@ExtendWith(MockitoExtension.class)
class ValidatePastDateAndTimeRegressionTest {
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
    void valid24HourTimeTest() {
        validator.validatePastDateAndTime("25/01/1953 17:25", field, nullMessage, formatMessage, pastMessage, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }


}