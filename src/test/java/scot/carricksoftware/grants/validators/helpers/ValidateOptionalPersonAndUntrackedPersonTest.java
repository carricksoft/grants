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
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class ValidateOptionalPersonAndUntrackedPersonTest {

    private ValidateTwoFieldTypes validateTwoFieldTypes;

    private String personField;
    private String untrackedField;
    private String message;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validateTwoFieldTypes = new ValidateTwoFieldTypesImpl();
        personField = "personField";
        untrackedField = "untrackedField";
        message = "message";
    }

    @Test
    void bothNullTest() {
        validateTwoFieldTypes.validateOptionalPersonAndUntrackedPerson(null, null, personField, untrackedField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void personValidOnlyTest() {
        validateTwoFieldTypes.validateOptionalPersonAndUntrackedPerson(GetRandomPerson(), null, personField, untrackedField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void untrackedValidOnlyTest() {
        validateTwoFieldTypes.validateOptionalPersonAndUntrackedPerson(null, GetRandomString(), personField, untrackedField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void bothValidTest() {
        validateTwoFieldTypes.validateOptionalPersonAndUntrackedPerson(GetRandomPerson(), GetRandomString(), personField, untrackedField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(personField, "", null, message);
        verify(bindingResultMock).rejectValue(untrackedField, "", null, message);
    }




}