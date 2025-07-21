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

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeathCertificateCommandValidatorTest {

    private DeathCertificateCommandValidator deathCertificateCommandValidator;

    @Mock
    private DeathCertificateNullFieldsValidator deathCertificateNullFieldsValidatorMock;

    @Mock
    private DeathCertificateUntrackedFieldsValidator deathCertificateUntrackedFieldsValidatorMock;

    @Mock
    private DeathCertificateCommand deathCertificateCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        deathCertificateCommandValidator = new DeathCertificateCommandValidatorImpl(
                deathCertificateNullFieldsValidatorMock,
                deathCertificateUntrackedFieldsValidatorMock);
    }

    @Test
    void validateTest() {
        deathCertificateCommandValidator.validate(deathCertificateCommandMock, bindingResultMock);
        verify(deathCertificateNullFieldsValidatorMock).validate(deathCertificateCommandMock, bindingResultMock);
        verify(deathCertificateUntrackedFieldsValidatorMock).validate(deathCertificateCommandMock, bindingResultMock);
    }
}