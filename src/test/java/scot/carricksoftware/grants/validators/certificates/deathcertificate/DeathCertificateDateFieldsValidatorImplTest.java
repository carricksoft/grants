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

    DeathCertificateDateFieldsValidator deathCertificateDateFieldsValidator;

    @Mock
    private ValidateDateTypes validateDateTypesMock;

    @Mock
    private BindingResult bindingResultMock;

    DeathCertificateCommand deathCertificateCommand;
    String certificateDate;
    String whenBorn;
    String whenDied;

    @BeforeEach
    void setUp() {
        deathCertificateDateFieldsValidator = new DeathCertificateDateFieldsValidatorImpl(validateDateTypesMock);
        deathCertificateCommand = new DeathCertificateCommandImpl();
        certificateDate = GetRandomString();
        whenBorn = GetRandomString();
        whenDied = GetRandomString();

        deathCertificateCommand.setCertificateDate(certificateDate);
        deathCertificateCommand.setWhenBorn(whenBorn);
        deathCertificateCommand.setWhenDied(whenDied);
    }

    @Test
    void validateCertificateDateIsCalledTest() {
        deathCertificateDateFieldsValidator.validate(deathCertificateCommand, bindingResultMock);

        verify(validateDateTypesMock).validatePastDate(certificateDate,
                "certificateDate",
                "The certificate date cannot be null.",
                "The certificate date is invalid or of the wrong format.",
                "Date should not be in the future.",
                bindingResultMock);
    }

    @Test
    void validateWhenBornIsCalledTest() {
        deathCertificateDateFieldsValidator.validate(deathCertificateCommand, bindingResultMock);

        verify(validateDateTypesMock).validatePastDate(whenBorn,
                "whenBorn",
                "When born cannot be null.",
                "The format should be dd/MM/yyyy hh:mm.",
                "Date should not be in the future.",
                bindingResultMock);
    }

    @Test
    void validateWhenDiedIsCalledTest() {
        deathCertificateDateFieldsValidator.validate(deathCertificateCommand, bindingResultMock);

        verify(validateDateTypesMock).validatePastDate(whenDied,
                "whenDied",
                "When died cannot be null.",
                "The format should be dd/MM/yyyy.",
                "Date should not be in the future.",
                bindingResultMock);
    }

}