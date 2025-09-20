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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class ValidateNonNegativeIntegerTest {

    private ValidateTypes validateTypes;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    public void setUp() {
        validateTypes = new ValidateTypesImpl();
    }

    @Test
    public void constructorTest() {
        assertNotNull(validateTypes);
    }

    @Test
    public void validateNullInteger() {
        String fieldName = GetRandomString();
        String nullMessage = GetRandomString();

        validateTypes.validateNonNegativeInteger(null, fieldName, nullMessage, "", "", bindingResultMock);
        verify(bindingResultMock).rejectValue(fieldName, "", null, nullMessage);
    }

    @Test
    public void validateEmptyInteger() {
        String fieldName = GetRandomString();
        String nullMessage = GetRandomString();

        validateTypes.validateNonNegativeInteger("", fieldName, nullMessage, "", "", bindingResultMock);
        verify(bindingResultMock).rejectValue(fieldName, "", null, nullMessage);
    }

    @Test
    public void validateNegativeInteger() {
        String fieldName = GetRandomString();
        String negativeMessage = GetRandomString();

        validateTypes.validateNonNegativeInteger("-5", fieldName, "", "", negativeMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(fieldName, "", null, negativeMessage);
    }

    @Test
    public void validateZeroInteger() {
        String fieldName = GetRandomString();

        validateTypes.validateNonNegativeInteger("0", fieldName, "", "", "", bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    public void validatePositiveInteger() {
        String fieldName = GetRandomString();

        validateTypes.validateNonNegativeInteger("1", fieldName, "", "", "", bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }


    @Test
    public void validateBadFormatInteger() {
        String fieldName = GetRandomString();
        String formatMessage = GetRandomString();

        validateTypes.validateNonNegativeInteger("zz", fieldName, "", formatMessage, "", bindingResultMock);
        verify(bindingResultMock).rejectValue(fieldName, "", null, formatMessage);
    }
}
