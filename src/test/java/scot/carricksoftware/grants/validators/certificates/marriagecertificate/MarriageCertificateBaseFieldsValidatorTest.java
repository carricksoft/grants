/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.marriagecertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.validators.helpers.ValidateDateTypes;
import scot.carricksoftware.grants.validators.helpers.ValidateTypesImpl;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MarriageCertificateBaseFieldsValidatorTest {

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private ValidateTypesImpl validateTypesMock;

    @Mock
    private ValidateDateTypes validateDateTypesMock;

    private MarriageCertificateCommand marriageCertificateCommand;

    @BeforeEach
    void setUp() {
        MarriageCertificateBaseFieldsValidator marriageCertificateBaseFieldsValidator = new MarriageCertificateBaseFieldsValidatorImpl(validateTypesMock, validateDateTypesMock);
        marriageCertificateCommand = new MarriageCertificateCommandImpl();
        marriageCertificateBaseFieldsValidator.validate(marriageCertificateCommand, bindingResultMock);
    }

    @Test
    void validateNullFieldsTest() {
        verify(validateTypesMock).validateNullOrEmptyString(marriageCertificateCommand.getCertificateNumber(),
                "certificateNumber","The certificate number cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(marriageCertificateCommand.getVolume(),
                "volume","The volume cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(marriageCertificateCommand.getNumber(),
                "number","The number cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateOrganisation(marriageCertificateCommand.getCertificateSource(),
                "certificateSource", "The certificate source cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateOrganisation(marriageCertificateCommand.getRegistrationAuthority(),
                "registrationAuthority","The registration authority cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateCertificateType(marriageCertificateCommand.getCertificateType(),
                "certificateType","The certificate type cannot be null.", bindingResultMock);
    }

    @Test
    void validateCertificateDateTest() {
        verify(validateDateTypesMock).validatePastDate(marriageCertificateCommand.getCertificateDate(),
                "certificateDate","The certificate date cannot be null.",
                "The certificate date is invalid or of the wrong format.",
                "Date should not be in the future.",
                bindingResultMock);
    }


}