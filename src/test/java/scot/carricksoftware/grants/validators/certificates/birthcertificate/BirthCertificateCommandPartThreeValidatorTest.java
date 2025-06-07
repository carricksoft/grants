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
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class BirthCertificateCommandPartThreeValidatorTest {

    private BirthCertificateCommandPartThreeValidator validator;

    @Mock
    private ValidateTypes validateTypesMock;

    @Mock()
    BirthCertificateCommand birthCertificateCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new BirthCertificateCommandPartThreeValidatorImpl(validateTypesMock);
    }

    @Test
    void validateWhereBornTest() {
        String where = GetRandomString();
        when(birthCertificateCommandMock.getWhereBorn()).thenReturn(where);
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(where, "whereBorn", "Where born cannot be null.", bindingResultMock);
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
        String whenBorn = GetRandomString();
        when(birthCertificateCommandMock.getWhenBorn()).thenReturn(whenBorn);
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validatePastDateAndTime(whenBorn, "whenBorn", "When born cannot be null.", "The format should be dd/MM/yyyy hh:mm.", "Date should not be in the future.", bindingResultMock);
    }

    @Test
    void validateFatherAndUntrackedFatherTest() {
        String untrackedFather = GetRandomString();
        Person father = GetRandomPerson();
        when(birthCertificateCommandMock.getUntrackedFather()).thenReturn(untrackedFather);
        when(birthCertificateCommandMock.getFather()).thenReturn(father);
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validatePersonAndUntrackedPerson(father, untrackedFather, "father", "unTrackedFather","One and only one father and untracked father must be specified.", bindingResultMock);
    }


}