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
class ValidateTypesPlaceAndUntrackedPlaceTest {

    private ValidateTypes validateTypes;

    private String untrackedPlaceField;
    private String placeField;
    private String message;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validateTypes = new ValidateTypesImpl();
        untrackedPlaceField = "untrackedWhereBorn";
        placeField = "whereBorn";
        message = GetRandomString();
    }

    @Test
    void bothNullTest() {
        validateTypes.validatePersonAndUntrackedPerson(null, null, placeField, untrackedPlaceField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(placeField, ApplicationConstants.EMPTY_STRING, null, message);
        verify(bindingResultMock).rejectValue(untrackedPlaceField, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void nullAndEmptyTest() {
        validateTypes.validatePersonAndUntrackedPerson(null, "  ", placeField, untrackedPlaceField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(placeField, ApplicationConstants.EMPTY_STRING, null, message);
        verify(bindingResultMock).rejectValue(untrackedPlaceField, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void bothFullTest() {
        validateTypes.validatePersonAndUntrackedPerson(GetRandomPerson(), GetRandomString(), placeField, untrackedPlaceField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(placeField, ApplicationConstants.EMPTY_STRING, null, message);
        verify(bindingResultMock).rejectValue(untrackedPlaceField, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void fullPersonAndNullUntrackedTest() {
        validateTypes.validatePersonAndUntrackedPerson(GetRandomPerson(), null, placeField, untrackedPlaceField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void fullPersonAndEmptyUntrackedTest() {
        validateTypes.validatePersonAndUntrackedPerson(GetRandomPerson(), "  ", placeField, untrackedPlaceField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void nullPersonAndFullUntrackedTest() {
        validateTypes.validatePersonAndUntrackedPerson(null, GetRandomString(), placeField, untrackedPlaceField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }


}