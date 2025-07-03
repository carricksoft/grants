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
import scot.carricksoftware.grants.validators.helpers.ValidateDateTypes;
import scot.carricksoftware.grants.validators.helpers.ValidateTwoFieldTypes;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class BirthCertificateCommandPartThreeValidatorTest {

    private BirthCertificateCommandPartThreeValidator validator;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock
    private ValidateTwoFieldTypes validateTwoFieldsTypesMock;

    @Mock
    private ValidateDateTypes validateDateTypesMock;

    @Mock
    private BirthCertificateCommand birthCertificateCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new BirthCertificateCommandPartThreeValidatorImpl(validateTypesMock, validateTwoFieldsTypesMock, validateDateTypesMock);
        when(birthCertificateCommandMock.getSex()).thenReturn(Sex.MALE);
        when(birthCertificateCommandMock.getWhenBorn()).thenReturn(GetRandomString());
        when(birthCertificateCommandMock.getFather()).thenReturn(GetRandomPerson());
        when(birthCertificateCommandMock.getWhereBorn()).thenReturn(GetRandomPlace());
        when(birthCertificateCommandMock.getUntrackedWhereBorn()).thenReturn(GetRandomString());
        when(birthCertificateCommandMock.getFatherUsualResidence()).thenReturn(GetRandomPlace());
        when(birthCertificateCommandMock.getUntrackedFatherUsualResidence()).thenReturn(GetRandomString());
        when(birthCertificateCommandMock.getWhenRegistered()).thenReturn(GetRandomString());
    }

    @Test
    void validatorAreCalledTest() {
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validateSex(birthCertificateCommandMock.getSex(),
                "sex", "Sex cannot be null.", bindingResultMock);
        verify(validateDateTypesMock).validatePastDateAndTime(birthCertificateCommandMock.getWhenBorn(),
                "whenBorn",
                "When born cannot be null.",
                "The format should be dd/MM/yyyy hh:mm.",
                "Date should not be in the future.",
                bindingResultMock);
        verify(validateTwoFieldsTypesMock).validatePersonAndUntrackedPerson(birthCertificateCommandMock.getFather(),
                birthCertificateCommandMock.getUntrackedFather(),
                "father",
                "untrackedFather",
                "One and only one father and untracked father must be specified.",
                bindingResultMock);
        verify(validateTwoFieldsTypesMock).validatePlaceAndUntrackedPlace(birthCertificateCommandMock.getWhereBorn(),
                birthCertificateCommandMock.getUntrackedWhereBorn(),
                "whereBorn",
                "untrackedWhereBorn",
                "One and only one where born and untracked where born must be specified.",
                bindingResultMock);
        verify(validateTwoFieldsTypesMock).validateOptionalPlaceAndUntrackedPlace(birthCertificateCommandMock.getFatherUsualResidence(),
                birthCertificateCommandMock.getUntrackedFatherUsualResidence(),
                "fatherUsualResidence",
                "untrackedFatherUsualResidence",
                "Only one usual residence and untracked usual residence must be specified.",
                bindingResultMock);
        verify(validateDateTypesMock).validatePastDate(birthCertificateCommandMock.getWhenRegistered(),
                "whenRegistered",
                "When registered cannot be null.",
                "When registered date is invalid.",
                "Date should not be in the future.",
                bindingResultMock);
    }
}