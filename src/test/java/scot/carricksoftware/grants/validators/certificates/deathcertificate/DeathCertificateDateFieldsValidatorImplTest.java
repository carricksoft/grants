/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.deathcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.validators.helpers.ValidateDateTypes;
import scot.carricksoftware.grants.validators.helpers.ValidateTypesImpl;

import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class DeathCertificateDateFieldsValidatorImplTest {

    DeathCertificateNullFieldsValidator deathCertificateNullFieldsValidator;

    @Mock
    private ValidateTypesImpl validateTypesMock;

    @Mock
    private ValidateDateTypes validateDateTypesMock;

    @Mock
    private BindingResult bindingResultMock;

    DeathCertificateCommand deathCertificateCommand;
    String certificateDate;

    @BeforeEach
    void setUp() {
        deathCertificateNullFieldsValidator = new DeathCertificateNullFieldsValidatorImpl(validateTypesMock, validateDateTypesMock);
        deathCertificateCommand = new DeathCertificateCommandImpl();
        certificateDate = GetRandomString();

        deathCertificateCommand.setCertificateDate(certificateDate);
    }

    @Test
    void validateDateTypesIsCalledTest() {
        deathCertificateNullFieldsValidator.validate(deathCertificateCommand, bindingResultMock);

        verify(validateDateTypesMock).validatePastDate(certificateDate,
                "certificateDate",
                "The certificate date cannot be null.",
                "The certificate date is invalid or of the wrong format.",
                "Date should not be in the future.",
                bindingResultMock);
    }

}