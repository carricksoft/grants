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
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.enums.censusentry.CensusEntrySex;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;


@ExtendWith(MockitoExtension.class)
class ValidateTypesNullTest {

    private ValidateTypes validateTypes;

    private String field;
    private String message;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validateTypes = new ValidateTypesImpl();
        field = "field";
        message = "message";
    }

    @Test
    void constructorTest() {
        assertNotNull(validateTypes);
    }

    @Test
    void nullPersonTest() {
        validateTypes.validatePerson(null, field, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void nonNullPersonTest() {
        validateTypes.validatePerson(new Person(), field, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void nullOrganisationTest() {
        validateTypes.validateOrganisation(null, field, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void nonNullOrganisationTest() {
        validateTypes.validateOrganisation(new Organisation(), field, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void nullSexTest() {
        validateTypes.validateSex(null, field, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void nonNullSexTest() {
        validateTypes.validateSex(CensusEntrySex.MALE, field, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }

    @Test
    void nullCertificateTypeTest() {
        validateTypes.validateCertificateType(null, field, message, bindingResultMock);
        verify(bindingResultMock).rejectValue(field, ApplicationConstants.EMPTY_STRING, null, message);
    }

    @Test
    void nonNullCertificateTypeTest() {
        validateTypes.validateCertificateType(CertificateType.EXTRACT, field, message, bindingResultMock);
        verifyNoInteractions(bindingResultMock);
    }
}