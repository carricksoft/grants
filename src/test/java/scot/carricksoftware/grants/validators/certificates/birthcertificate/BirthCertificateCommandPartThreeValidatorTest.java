/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.birthcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;
import scot.carricksoftware.grants.validators.helpers.ValidateTwoFieldTypes;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

@ExtendWith(MockitoExtension.class)
class BirthCertificateCommandPartThreeValidatorTest {

    private BirthCertificateCommandPartThreeValidator validator;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock
    private ValidateTwoFieldTypes validateTwoFieldsTypesMock;

    @Mock()
    BirthCertificateCommand birthCertificateCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new BirthCertificateCommandPartThreeValidatorImpl(validateTypesMock, validateTwoFieldsTypesMock);
    }

    @Test
    void validateSexTest() {
        Sex sex = Sex.MALE;
        when(birthCertificateCommandMock.getSex()).thenReturn(sex);
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validateSex(sex, "sex", "Sex cannot be null.", bindingResultMock);
    }


    @Test
    void validateWhenBornTest() {
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validatePastDateAndTime(
                birthCertificateCommandMock.getWhenBorn(),
                "whenBorn",
                "When born cannot be null.",
                "The format should be dd/MM/yyyy hh:mm.",
                "Date should not be in the future.",
                bindingResultMock);
    }

    @Test
    void validateRegisteredDateTest() {
        String string = GetRandomString();
        when(birthCertificateCommandMock.getWhenRegistered()).thenReturn(string);
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validatePastDate(
                string,
                "whenRegistered",
                "When registered cannot be null.",
                "When registered date is invalid.",
                "Date should not be in the future.",
                bindingResultMock);
    }

}