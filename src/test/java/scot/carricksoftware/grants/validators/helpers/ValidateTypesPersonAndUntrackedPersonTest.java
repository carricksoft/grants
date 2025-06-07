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
class ValidateTypesPersonAndUntrackedPersonTest {

    private ValidateTypes validateTypes;

    private String untrackedPersonField;
    private String personField;
    private String message;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validateTypes = new ValidateTypesImpl();
        untrackedPersonField = "untrackedPerson";
        personField = "person";
        message = GetRandomString();
    }

    @Test
    void bothNullTest() {
        validateTypes.validatePersonAndUntrackedPerson(null, null, personField, untrackedPersonField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(personField, ApplicationConstants.EMPTY_STRING, null, message);
        verify(bindingResultMock).rejectValue(untrackedPersonField, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void nullAndEmptyTest() {
        validateTypes.validatePersonAndUntrackedPerson(null, "  ", personField, untrackedPersonField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(personField, ApplicationConstants.EMPTY_STRING, null, message);
        verify(bindingResultMock).rejectValue(untrackedPersonField, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void bothFullTest() {
        validateTypes.validatePersonAndUntrackedPerson(GetRandomPerson(), GetRandomString(), personField, untrackedPersonField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(personField, ApplicationConstants.EMPTY_STRING, null, message);
        verify(bindingResultMock).rejectValue(untrackedPersonField, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void fullPersonAndNullUntrackedTest() {
        validateTypes.validatePersonAndUntrackedPerson(GetRandomPerson(), null, personField, untrackedPersonField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void fullPersonAndEmptyUntrackedTest() {
        validateTypes.validatePersonAndUntrackedPerson(GetRandomPerson(), "  ", personField, untrackedPersonField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void nullPersonAndFullUntrackedTest() {
        validateTypes.validatePersonAndUntrackedPerson(null, GetRandomString(), personField, untrackedPersonField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }



}