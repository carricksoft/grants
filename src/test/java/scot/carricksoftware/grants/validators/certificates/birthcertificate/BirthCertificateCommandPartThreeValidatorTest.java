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
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.general.Sex;
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

    @Mock()
    BirthCertificateCommand birthCertificateCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        validator = new BirthCertificateCommandPartThreeValidatorImpl(validateTypesMock);
    }

    @Test
    void validateSexTest() {
        Sex sex = Sex.MALE;
        when(birthCertificateCommandMock.getSex()).thenReturn(sex);
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validateSex(sex, "sex", "Sex cannot be null.", bindingResultMock);
    }

    @Test
    void validateFatherAndUntrackedFatherTest() {
        String untrackedFather = GetRandomString();
        Person father = GetRandomPerson();
        when(birthCertificateCommandMock.getUntrackedFather()).thenReturn(untrackedFather);
        when(birthCertificateCommandMock.getFather()).thenReturn(father);
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validatePersonAndUntrackedPerson(
                father,
                untrackedFather,
                "father",
                "untrackedFather",
                "One and only one father and untracked father must be specified.",
                bindingResultMock);
    }

    @Test
    void validateWhereBornAndUntrackedWhereBornTest() {
        String untrackedWhereBorn = GetRandomString();
        Place whereBorn = GetRandomPlace();
        when(birthCertificateCommandMock.getUntrackedWhereBorn()).thenReturn(untrackedWhereBorn);
        when(birthCertificateCommandMock.getWhereBorn()).thenReturn(whereBorn);
        validator.validate(birthCertificateCommandMock, bindingResultMock);
        verify(validateTypesMock).validatePlaceAndUntrackedPlace(
                whereBorn,
                untrackedWhereBorn,
                "whereBorn",
                "untrackedWhereBorn",
                "One and only one where born and untracked where born must be specified.",
                bindingResultMock);
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