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
class ValidateIntegerAsteriskRangeTest {

    private ValidateTypes validateTypes;

    @Mock
    private BindingResult bindingResultMock;

    String fieldName;

    @BeforeEach
    public void setUp() {
        validateTypes = new ValidateTypesImpl();
        fieldName = GetRandomString();
    }

    @Test
    public void constructorTest() {
        assertNotNull(validateTypes);
    }

    @Test
    public void validateNullInteger() {
        String nullMessage = GetRandomString();

        validateTypes.validateIntegerAsteriskRange(null, null, null, fieldName, nullMessage, "", "", bindingResultMock);
        verify(bindingResultMock).rejectValue(fieldName, "", null, nullMessage);
    }

    @Test
    public void validateEmptyInteger() {
        String nullMessage = GetRandomString();

        validateTypes.validateIntegerAsteriskRange("*", null, null, fieldName, nullMessage, "", "", bindingResultMock);
        verify(bindingResultMock).rejectValue(fieldName, "", null, nullMessage);
    }

    @Test
    public void validateBadFormatInteger() {
        String formatMessage = GetRandomString();

        validateTypes.validateIntegerAsteriskRange("zz", null, null, fieldName, "", formatMessage, "", bindingResultMock);
        verify(bindingResultMock).rejectValue(fieldName, "", null, formatMessage);
    }

    @Test
    public void validateTooLowInteger() {
        String rangeMessage = GetRandomString();

        validateTypes.validateIntegerAsteriskRange("-6*", -5, 99, fieldName, "", "", rangeMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(fieldName, "", null, rangeMessage);
    }

    @Test
    public void validateLowLimitInteger() {
        validateTypes.validateIntegerAsteriskRange("-6*", -6, 99, fieldName, "", "", "", bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    public void validateHighLimitInteger() {
        validateTypes.validateIntegerAsteriskRange("10*", -6, 10, fieldName, "", "", "", bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    public void validateTooHighInteger() {
        String rangeMessage = GetRandomString();

        validateTypes.validateIntegerAsteriskRange("11*", -5, 10, fieldName, "", "", rangeMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(fieldName, "", null, rangeMessage);
    }


}
