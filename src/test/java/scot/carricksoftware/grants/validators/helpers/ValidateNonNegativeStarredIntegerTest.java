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
class ValidateNonNegativeStarredIntegerTest {

    private ValidateTypes validateTypes;

    @Mock
    private BindingResult bindingResultMock;

    private String fieldName;

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

        validateTypes.validateNonNegativeStaredInteger(null, fieldName, nullMessage, "", "", bindingResultMock);
        verify(bindingResultMock).rejectValue(fieldName, "", null, nullMessage);
    }


    @Test
    void validateEmptyInteger() {
        String nullMessage = GetRandomString();

        validateTypes.validateNonNegativeStaredInteger("", fieldName, nullMessage, "", "", bindingResultMock);
        verify(bindingResultMock).rejectValue(fieldName, "", null, nullMessage);
    }

    @Test
    void validateStarInteger() {
        String nullMessage = GetRandomString();

        validateTypes.validateNonNegativeStaredInteger("*", fieldName, nullMessage, "", "", bindingResultMock);
        verify(bindingResultMock).rejectValue(fieldName, "", null, nullMessage);
    }

    @Test
    void validateNegativeInteger() {
        String negativeMessage = GetRandomString();

        validateTypes.validateNonNegativeStaredInteger("-7", fieldName, "", "", negativeMessage, bindingResultMock);
        verify(bindingResultMock).rejectValue(fieldName, "", null, negativeMessage);
    }

    @Test
    void validateZeroInteger() {
        validateTypes.validateNonNegativeStaredInteger("0", fieldName, "", "", "", bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void validatePositiveInteger() {
        validateTypes.validateNonNegativeStaredInteger("1", fieldName, "", "", "", bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void validateStarredPositiveInteger() {
        validateTypes.validateNonNegativeStaredInteger("1*", fieldName, "", "", "", bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }


    @Test
    void validateBadFormatInteger() {
        String formatMessage = GetRandomString();

        validateTypes.validateNonNegativeStaredInteger("zz", fieldName, "", formatMessage, "", bindingResultMock);
        verify(bindingResultMock).rejectValue(fieldName, "", null, formatMessage);
    }
}
