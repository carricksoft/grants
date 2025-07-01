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
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class ValidatePlaceAndUntrackedPlaceTest {

    private ValidateTwoFieldTypes validateTwoFieldTypes;

    private String placeField;
    private String untrackedField;
    private String message;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validateTwoFieldTypes = new ValidateTwoFieldTypesImpl();
        placeField = "personField";
        untrackedField = "untrackedField";
        message = "message";
    }

    @Test
    void bothNullTest() {
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(null, null, placeField, untrackedField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(placeField, "", null, message);
        verify(bindingResultMock).rejectValue(untrackedField, "", null, message);
    }

    @Test
    void nullPlaceAndEmptyUntrackedFieldTest() {
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(null, "", placeField, untrackedField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(placeField, "", null, message);
        verify(bindingResultMock).rejectValue(untrackedField, "", null, message);
    }

    @Test
    void bothGivenFieldTest() {
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(GetRandomPlace(), GetRandomString(), placeField, untrackedField, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(placeField, "", null, message);
        verify(bindingResultMock).rejectValue(untrackedField, "", null, message);
    }

    @Test
    void placeOnlyGivenTest() {
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(GetRandomPlace(), null, placeField, untrackedField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void unTrackedPlaceOnlyGivenTest() {
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(null, GetRandomString(), placeField, untrackedField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }


}