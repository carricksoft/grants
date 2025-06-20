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
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;


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
        validateTypes.validatePlaceAndUntrackedPlace(null, null, placeField, untrackedPlaceField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(placeField, ApplicationConstants.EMPTY_STRING, null, message);
        verify(bindingResultMock).rejectValue(untrackedPlaceField, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void nullAndEmptyTest() {
        validateTypes.validatePlaceAndUntrackedPlace(null, "  ", placeField, untrackedPlaceField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(placeField, ApplicationConstants.EMPTY_STRING, null, message);
        verify(bindingResultMock).rejectValue(untrackedPlaceField, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void bothFullTest() {
        validateTypes.validatePlaceAndUntrackedPlace(GetRandomPlace(), GetRandomString(), placeField, untrackedPlaceField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(placeField, ApplicationConstants.EMPTY_STRING, null, message);
        verify(bindingResultMock).rejectValue(untrackedPlaceField, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void fullPersonAndNullUntrackedTest() {
        validateTypes.validatePlaceAndUntrackedPlace(GetRandomPlace(), null, placeField, untrackedPlaceField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void fullPersonAndEmptyUntrackedTest() {
        validateTypes.validatePlaceAndUntrackedPlace(GetRandomPlace(), "  ", placeField, untrackedPlaceField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void nullPersonAndFullUntrackedTest() {
        validateTypes.validatePlaceAndUntrackedPlace(null, GetRandomString(), placeField, untrackedPlaceField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }


}