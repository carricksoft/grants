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
import scot.carricksoftware.grants.validators.helpers.ValidateTwoFieldTypes;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DivorceCertificatePeopleValidatorTest {

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock
    private ValidateTwoFieldTypes validateTwoFieldTypesMock;

    private DivorceCertificateCommand divorceCertificateCommand;

    @BeforeEach
    void setUp() {
        DivorceCertificateCommandPeopleValidator divorceCertificateCommandPeopleValidator = new DivorceCertificateCommandPeopleValidatorImpl(validateTypesMock, validateTwoFieldTypesMock);
        divorceCertificateCommand = new DivorceCertificateCommandImpl();
        divorceCertificateCommandPeopleValidator.validate(divorceCertificateCommand, bindingResultMock);
    }

    @Test
    void validatePeopleTest() {
        verify(validateTypesMock).validatePerson(divorceCertificateCommand.getFirstParty(), "firstParty", "The first party cannot be null.", bindingResultMock);
        verify(validateTypesMock).validatePerson(divorceCertificateCommand.getSecondParty(), "secondParty", "The second party cannot be null.", bindingResultMock);
        verify(validateTwoFieldTypesMock).validateNotSamePerson(divorceCertificateCommand.getFirstParty(), divorceCertificateCommand.getSecondParty(),
                "firstParty", "secondParty", "The two parties cannot be the same person.", bindingResultMock);
    }

}