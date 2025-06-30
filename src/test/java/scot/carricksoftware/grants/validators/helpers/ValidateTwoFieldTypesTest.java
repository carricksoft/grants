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
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class ValidateTwoFieldTypesTest {

    ValidateTwoFieldTypes validateTwoFieldTypes;

    @Mock
    private BindingResult bindingResultMock;

    private String untrackedPlaceField;
    private String placeField;
    private String message;

    @BeforeEach
    void setUp() {
        validateTwoFieldTypes = new ValidateTwoFieldTypesImpl();
        untrackedPlaceField = "untrackedWhereBorn";
        placeField = "whereBorn";
        message = GetRandomString();
    }

    @Test
    void fullPersonAndNullUntrackedTest() {
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(GetRandomPlace(), null, placeField, untrackedPlaceField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void fullPersonAndEmptyUntrackedTest() {
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(GetRandomPlace(), "  ", placeField, untrackedPlaceField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void nullPersonAndFullUntrackedTest() {
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(null, GetRandomString(), placeField, untrackedPlaceField, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

}