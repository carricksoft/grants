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
import scot.carricksoftware.grants.validators.helpers.ValidateDateTypesImpl;
import scot.carricksoftware.grants.validators.helpers.ValidateTypesImpl;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MarriageCertificateNullFieldsValidatorTest {

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private ValidateTypesImpl validateTypesMock;

    @Mock
    private ValidateDateTypesImpl validateDateTypesMock;

    private MarriageCertificateCommand marriageCertificateCommand;

    @BeforeEach
    void setUp() {
        MarriageCertificateNullFieldsValidator marriageCertificateNullFieldsValidator = new MarriageCertificateNullFieldsValidatorImpl(
                validateTypesMock,
                validateDateTypesMock);
        marriageCertificateCommand = new MarriageCertificateCommandImpl();
        marriageCertificateNullFieldsValidator.validate(marriageCertificateCommand, bindingResultMock);
    }

    @Test
    void validateNullOrEmptyStringTest() {
        verify(validateTypesMock).validateNullOrEmptyString(marriageCertificateCommand.getGroomAge(),
                "groomAge", "The groom age cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(marriageCertificateCommand.getGroomRank(),
                "groomRank", "The groom rank cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(marriageCertificateCommand.getGroomCondition(),
                "groomCondition", "The groom condition cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(marriageCertificateCommand.getBrideAge(),
                "brideAge", "The bride age cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(marriageCertificateCommand.getBrideRank(),
                "brideRank", "The bride rank cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(marriageCertificateCommand.getBrideCondition(),
                "brideCondition", "The bride condition cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(marriageCertificateCommand.getBrideFatherRank(),
                "brideFatherRank", "The bride's father's rank cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(marriageCertificateCommand.getGroomFatherRank(),
                "groomFatherRank", "The groom's father's rank cannot be null.", bindingResultMock);
    }

    @Test
    void validatePersonTest() {
        verify(validateTypesMock).validatePerson(marriageCertificateCommand.getGroom(),
                "groom", "The groom cannot be null.", bindingResultMock);
        verify(validateTypesMock).validatePerson(marriageCertificateCommand.getBride(),
                "bride", "The bride cannot be null.", bindingResultMock);
    }


}