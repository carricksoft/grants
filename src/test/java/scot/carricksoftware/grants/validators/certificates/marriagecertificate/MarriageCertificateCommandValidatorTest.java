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

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MarriageCertificateCommandValidatorTest {

    private MarriageCertificateCommandValidator marriageCertificateCommandValidator;

    @Mock
    private MarriageCertificateNullFieldsValidator marriageCertificateNullFieldsValidatorMock;

    @Mock
    private MarriageCertificateBaseFieldsValidator marriageCertificateBaseFieldsValidatorMock;

    @Mock
    private MarriageCertificateUntrackedFieldsValidator marriageCertificateUntrackedFieldsValidatorMock;

    @Mock
    private MarriageCertificateCommand marriageCertificateCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        marriageCertificateCommandValidator = new MarriageCertificateCommandValidatorImpl(
                marriageCertificateNullFieldsValidatorMock,
                marriageCertificateBaseFieldsValidatorMock,
                marriageCertificateUntrackedFieldsValidatorMock);
    }

    @Test
    void validateTest() {
        marriageCertificateCommandValidator.validate(marriageCertificateCommandMock, bindingResultMock);
        verify(marriageCertificateNullFieldsValidatorMock).validate(marriageCertificateCommandMock, bindingResultMock);
        verify(marriageCertificateBaseFieldsValidatorMock).validate(marriageCertificateCommandMock, bindingResultMock);
        verify(marriageCertificateUntrackedFieldsValidatorMock).validate(marriageCertificateCommandMock, bindingResultMock);
    }
}