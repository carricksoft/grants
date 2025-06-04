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
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.enums.certificates.CertificateType;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateGeneralRandomEnums.GetRandomCertificateType;

@ExtendWith(MockitoExtension.class)
class BirthCertificateCommandPartOneValidatorTest {

    private BirthCertificateCommandPartOneValidator validator;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock()
    BirthCertificateCommand birthCertificateCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new BirthCertificateCommandPartOneValidatorImpl(validateTypesMock);
    }

    @Test
    void validateNewBornTest() {
        when(birthCertificateCommandMock.getNewBorn()).thenReturn(new Person());
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validatePerson(birthCertificateCommandMock.getNewBorn(), "newBorn", "The New Born cannot be null.", bindingResultMock);
    }

    @Test
    void validateCertificateNumberTest() {
        String string = GetRandomString();
        when(birthCertificateCommandMock.getCertificateNumber()).thenReturn(string);
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(string, "certificateNumber", "The certificate number cannot be null.", bindingResultMock);
    }

    @Test
    void validateCertificateSourceTest() {
        when(birthCertificateCommandMock.getCertificateSource()).thenReturn(new Organisation());
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validateOrganisation(birthCertificateCommandMock.getCertificateSource(), "certificateSource", "The certificate source cannot be null.", bindingResultMock);
    }

    @Test
    void validateCertificateTypeTest() {
        CertificateType certificateType = GetRandomCertificateType();
        when(birthCertificateCommandMock.getCertificateType()).thenReturn(certificateType);
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validateCertificateType(certificateType, "certificateType", "The certificate type cannot be null.", bindingResultMock);
    }

    @Test
    void validateCertificateDateTest() {
        String string = GetRandomString();
        when(birthCertificateCommandMock.getCertificateDate()).thenReturn(string);
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validatePastDate(
                string,
                "certificateDate",
                "The certificate date cannot be null.",
                "The certificate date is invalid or of the wrong format.",
                "Date should not be in the future.",
                bindingResultMock);
    }


}