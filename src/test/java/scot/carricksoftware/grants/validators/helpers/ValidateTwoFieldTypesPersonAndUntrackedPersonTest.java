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
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;


@ExtendWith(MockitoExtension.class)
class ValidateTwoFieldTypesPersonAndUntrackedPersonTest {

    private ValidateTypes validateTwoTypes;

    private String untrackedPersonField;
    private String personField;
    private String message;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validateTwoTypes = new ValidateTypesImpl();
        untrackedPersonField = "untrackedPerson";
        personField = "person";
        message = GetRandomString();
    }

    @Test
    void bothNullTest() {
        validateTwoTypes.validatePersonAndUntrackedPerson(null, null, personField, untrackedPersonField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(personField, ApplicationConstants.EMPTY_STRING, null, message);
        verify(bindingResultMock).rejectValue(untrackedPersonField, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void nullAndEmptyTest() {
        validateTwoTypes.validatePersonAndUntrackedPerson(null, "  ", personField, untrackedPersonField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(personField, ApplicationConstants.EMPTY_STRING, null, message);
        verify(bindingResultMock).rejectValue(untrackedPersonField, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void bothFullTest() {
        validateTwoTypes.validatePersonAndUntrackedPerson(GetRandomPerson(), GetRandomString(), personField, untrackedPersonField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(personField, ApplicationConstants.EMPTY_STRING, null, message);
        verify(bindingResultMock).rejectValue(untrackedPersonField, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void fullPersonAndNullUntrackedTest() {
        validateTwoTypes.validatePersonAndUntrackedPerson(GetRandomPerson(), null, personField, untrackedPersonField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void fullPersonAndEmptyUntrackedTest() {
        validateTwoTypes.validatePersonAndUntrackedPerson(GetRandomPerson(), "  ", personField, untrackedPersonField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void nullPersonAndFullUntrackedTest() {
        validateTwoTypes.validatePersonAndUntrackedPerson(null, GetRandomString(), personField, untrackedPersonField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }


}