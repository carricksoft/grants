/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.birthcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.enums.certificates.CertificateType;
import scot.carricksoftware.grants.validators.helpers.ValidateDateTypes;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;

@ExtendWith(MockitoExtension.class)
class BirthCertificateCommandPartOneValidatorTest {

    private BirthCertificateCommandPartOneValidator validator;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock
    private ValidateDateTypes validateDateTypesMock;

    @Mock
    private BirthCertificateCommand birthCertificateCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new BirthCertificateCommandPartOneValidatorImpl(validateTypesMock, validateDateTypesMock);
        when(birthCertificateCommandMock.getNewBorn()).thenReturn(GetRandomPerson());
        when(birthCertificateCommandMock.getCertificateNumber()).thenReturn(GetRandomString());
        when(birthCertificateCommandMock.getCertificateSource()).thenReturn(GetRandomOrganisation());
        when(birthCertificateCommandMock.getCertificateType()).thenReturn(CertificateType.EXTRACT);
        when(birthCertificateCommandMock.getCertificateDate()).thenReturn(GetRandomString());
        when(birthCertificateCommandMock.getMother()).thenReturn(GetRandomPerson());
    }

    @Test
    void validatorAreCalledTest() {
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validatePerson(birthCertificateCommandMock.getNewBorn(),
                "newBorn", "The New Born cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(birthCertificateCommandMock.getCertificateNumber(),
                "certificateNumber", "The certificate number cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateOrganisation(birthCertificateCommandMock.getCertificateSource(),
                "certificateSource", "The certificate source cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateCertificateType(birthCertificateCommandMock.getCertificateType(),
                "certificateType", "The certificate type cannot be null.", bindingResultMock);
        verify(validateDateTypesMock).validatePastDate(birthCertificateCommandMock.getCertificateDate(),
                "certificateDate",
                "The certificate date cannot be null.",
                "The certificate date is invalid or of the wrong format.",
                "Date should not be in the future.",
                bindingResultMock);
        verify(validateTypesMock).validatePerson(birthCertificateCommandMock.getMother(),
                "mother", "The mother cannot be null.", bindingResultMock);
    }
}