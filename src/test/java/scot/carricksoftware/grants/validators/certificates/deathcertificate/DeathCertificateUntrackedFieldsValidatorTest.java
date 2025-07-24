/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.deathcertificate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.validators.helpers.ValidateTwoFieldTypes;

import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class DeathCertificateUntrackedFieldsValidatorTest {

    private DeathCertificateUntrackedFieldsValidator deathCertificateUntrackedFieldsValidator;

    @Mock
    private ValidateTwoFieldTypes validateTwoFieldTypesMock;

    @Mock
    private BindingResult bindingResultMock;

    private DeathCertificateCommand deathCertificateCommand;

    private Person spouse;
    private String untrackedSpouse;
    private Person father;
    private String untrackedFather;
    private Place whereDied;
    private String untrackedWhereDied;
    private Place usualResidence;
    private String untrackedUsualResidence;
    private Person mother;
    private String untrackedMother;
    private Person informant;
    private String untrackedInformant;

    @BeforeEach
    void setUp() {
        deathCertificateUntrackedFieldsValidator = new DeathCertificateUntrackedFieldsValidatorImpl(validateTwoFieldTypesMock);
        deathCertificateCommand = new DeathCertificateCommandImpl();
        spouse = GetRandomPerson();
        father = GetRandomPerson();
        whereDied = GetRandomPlace();
        usualResidence = GetRandomPlace();
        untrackedSpouse = GetRandomString();
        untrackedFather = GetRandomString();
        untrackedWhereDied = GetRandomString();
        untrackedUsualResidence = GetRandomString();
        mother = GetRandomPerson();
        untrackedMother = GetRandomString();
        informant = GetRandomPerson();
        untrackedInformant = GetRandomString();

        deathCertificateCommand.setSpouse(spouse);
        deathCertificateCommand.setUntrackedSpouse(untrackedSpouse);
        deathCertificateCommand.setFather(father);
        deathCertificateCommand.setUntrackedFather(untrackedFather);
        deathCertificateCommand.setMother(mother);
        deathCertificateCommand.setUntrackedMother(untrackedMother);
        deathCertificateCommand.setInformant(informant);
        deathCertificateCommand.setUntrackedInformant(untrackedInformant);

        deathCertificateCommand.setWhereDied(whereDied);
        deathCertificateCommand.setUntrackedWhereDied(untrackedWhereDied);
        deathCertificateCommand.setUsualResidence(usualResidence);
        deathCertificateCommand.setUntrackedUsualResidence(untrackedUsualResidence);
    }

    @Test
    void theTestAreRunTest() {
        deathCertificateUntrackedFieldsValidator.validate(deathCertificateCommand, bindingResultMock);
        verify(validateTwoFieldTypesMock).validatePersonAndUntrackedPerson(spouse, untrackedSpouse, "spouse", "untrackedSpouse",
                "One and only one spouse and untracked spouse must be specified.", bindingResultMock);
        verify(validateTwoFieldTypesMock).validateOptionalPersonAndUntrackedPerson(father, untrackedFather, "father", "untrackedFather",
               "One and only one father and untracked father may be specified.", bindingResultMock);
        verify(validateTwoFieldTypesMock).validatePlaceAndUntrackedPlace(whereDied, untrackedWhereDied, "whereDied", "untrackedWhereDied",
               "One and only one where died and untracked where died must be specified.", bindingResultMock);
        verify(validateTwoFieldTypesMock).validateOptionalPlaceAndUntrackedPlace(usualResidence, untrackedUsualResidence, "usualResidence", "untrackedUsualResidence",
                "Only one usual residence and untracked usual residence may be specified.", bindingResultMock);
        verify(validateTwoFieldTypesMock).validatePersonAndUntrackedPerson(mother, untrackedMother, "mother", "untrackedMother",
                "One and only one mother and untracked mother may be specified.", bindingResultMock);
        verify(validateTwoFieldTypesMock).validatePersonAndUntrackedPerson(informant, untrackedInformant, "informant", "untrackedInformant",
                "One and only one informant and untracked informant may be specified.", bindingResultMock);
    }


}