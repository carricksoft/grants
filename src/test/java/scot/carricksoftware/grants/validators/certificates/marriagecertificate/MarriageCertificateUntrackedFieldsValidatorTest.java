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
import scot.carricksoftware.grants.validators.helpers.ValidateTwoFieldTypes;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MarriageCertificateUntrackedFieldsValidatorTest {

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private ValidateTwoFieldTypes validateTwoFieldsTypesMock;

    private MarriageCertificateCommand marriageCertificateCommand;

    @BeforeEach
    void setUp() {
        MarriageCertificateUntrackedFieldsValidator marriageCertificateUntrackedFieldsValidator = new MarriageCertificateUntrackedFieldsValidatorImpl(validateTwoFieldsTypesMock);
        marriageCertificateCommand = new MarriageCertificateCommandImpl();
        marriageCertificateUntrackedFieldsValidator.validate(marriageCertificateCommand, bindingResultMock);
    }

    @Test
    void validateFieldsTest() {
        verify(validateTwoFieldsTypesMock).validatePlaceAndUntrackedPlace(marriageCertificateCommand.getWhereMarried(),
                marriageCertificateCommand.getUntrackedWhereMarried(), "whereMarried", "untrackedWhereMarried",
                "One and only one where married and untracked where married must be specified.", bindingResultMock);
        verify(validateTwoFieldsTypesMock).validatePlaceAndUntrackedPlace(marriageCertificateCommand.getGroomUsualResidence(),
                marriageCertificateCommand.getGroomUntrackedResidence(), "groomUsualResidence", "groomUntrackedResidence",
                "One and only one groom residence and untracked groom residence may be specified.", bindingResultMock);
        verify(validateTwoFieldsTypesMock).validatePlaceAndUntrackedPlace(marriageCertificateCommand.getBrideUsualResidence(),
                marriageCertificateCommand.getBrideUntrackedResidence(), "brideUsualResidence", "brideUntrackedResidence",
                "One and only one bride residence and untracked bride residence may be specified.", bindingResultMock);
        verify(validateTwoFieldsTypesMock).validatePersonAndUntrackedPerson(marriageCertificateCommand.getGroomFather(),
                marriageCertificateCommand.getGroomUntrackedFather(), "groomFather", "groomUntrackedFather",
                "One and only one groom father and untracked groom father may be specified.", bindingResultMock);
        verify(validateTwoFieldsTypesMock).validatePersonAndUntrackedPerson(marriageCertificateCommand.getBrideFather(),
                marriageCertificateCommand.getBrideUntrackedFather(), "brideFather", "brideUntrackedFather",
                "One and only one bride father and untracked bride father may be specified.", bindingResultMock);
        verify(validateTwoFieldsTypesMock).validatePersonAndUntrackedPerson(marriageCertificateCommand.getFirstWitness(),
                marriageCertificateCommand.getUntrackedFirstWitness(), "firstWitness", "untrackedFirstWitness",
                "One and only one first witness and untracked first witness may be specified.", bindingResultMock);
        verify(validateTwoFieldsTypesMock).validatePersonAndUntrackedPerson(marriageCertificateCommand.getSecondWitness(),
                marriageCertificateCommand.getUntrackedSecondWitness(), "secondWitness", "untrackedSecondWitness",
                "One and only one second witness and untracked second witness may be specified.", bindingResultMock);
    }


}