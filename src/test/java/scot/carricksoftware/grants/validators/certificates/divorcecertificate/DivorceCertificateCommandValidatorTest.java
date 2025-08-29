/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.divorcecertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;


import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DivorceCertificateCommandValidatorTest {

    private DivorceCertificateCommandValidator divorceCertificateCommandValidator;

    @Mock
    private DivorceCertificateCommandPeopleValidator divorceCertificateCommandPeopleValidatorMock;

    @Mock
    private DivorceCertificateCommandDatesValidator divorceCertificateCommandDatesValidatorMock;


    @Mock
    private DivorceCertificateCommand divorceCertificateCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        divorceCertificateCommandValidator = new DivorceCertificateCommandValidatorImpl(
                divorceCertificateCommandPeopleValidatorMock,
                divorceCertificateCommandDatesValidatorMock);
    }

    @Test
    void validateTest() {
        divorceCertificateCommandValidator.validate(divorceCertificateCommandMock, bindingResultMock);
        verify(divorceCertificateCommandPeopleValidatorMock).validate(divorceCertificateCommandMock, bindingResultMock);
        verify(divorceCertificateCommandDatesValidatorMock).validate(divorceCertificateCommandMock, bindingResultMock);
    }
}