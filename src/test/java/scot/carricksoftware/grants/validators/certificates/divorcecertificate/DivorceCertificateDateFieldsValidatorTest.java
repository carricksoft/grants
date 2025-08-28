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
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommandImpl;
import scot.carricksoftware.grants.validators.helpers.ValidateDateTypes;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DivorceCertificateDateFieldsValidatorTest {

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private ValidateDateTypes validateDateTypesMock;

    private DivorceCertificateCommand divorceCertificateCommand;

    @BeforeEach
    void setUp() {
        DivorceCertificateCommandDatesValidator divorceCertificateDateFieldsValidator = new DivorceCertificateCommandDatesValidatorImpl(validateDateTypesMock);
        divorceCertificateCommand = new DivorceCertificateCommandImpl();
        divorceCertificateDateFieldsValidator.validate(divorceCertificateCommand, bindingResultMock);
    }

    @Test
    void validateDateFieldsTest() {
        verify(validateDateTypesMock).validatePastDate(divorceCertificateCommand.getFirstPartyDate(), "firstPartyDate",
                "The first party date cannot be null.", "The format should be dd/MM/yyyy.", "Date should not be in the future.",bindingResultMock);
        verify(validateDateTypesMock).validatePastDate(divorceCertificateCommand.getSecondPartyDate(), "secondPartyDate",
                "The second party date cannot be null.", "The format should be dd/MM/yyyy.", "Date should not be in the future.",bindingResultMock);
        verify(validateDateTypesMock).validatePastDate(divorceCertificateCommand.getRegisteredDate(), "registeredDate",
                "The registered date cannot be null.", "The format should be dd/MM/yyyy.", "Date should not be in the future.",bindingResultMock);
    }

}