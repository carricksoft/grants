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
import scot.carricksoftware.grants.domains.people.Person;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class ValidateNotSamePersonTest {

    private ValidateTwoFieldTypes validateTwoFieldTypes;

    private String message;

    private String firstPersonFieldName;
    private String secondPersonFieldName;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validateTwoFieldTypes = new ValidateTwoFieldTypesImpl();
        message = "message";
        firstPersonFieldName = GetRandomString();
        secondPersonFieldName = GetRandomString();
    }

    @Test
    void nullFirstPersonTest() {
        validateTwoFieldTypes.validateNotSamePerson(null, GetRandomPerson(), firstPersonFieldName, secondPersonFieldName, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void nullSecondPersonTest() {
        validateTwoFieldTypes.validateNotSamePerson(GetRandomPerson(), null, firstPersonFieldName, secondPersonFieldName, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void TwoTheSameTest() {
        Person person = GetRandomPerson();
        validateTwoFieldTypes.validateNotSamePerson(person, person, firstPersonFieldName, secondPersonFieldName, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(firstPersonFieldName, ApplicationConstants.EMPTY_STRING, null, message);
        verify(bindingResultMock).rejectValue(secondPersonFieldName, ApplicationConstants.EMPTY_STRING, null, message);
    }
}