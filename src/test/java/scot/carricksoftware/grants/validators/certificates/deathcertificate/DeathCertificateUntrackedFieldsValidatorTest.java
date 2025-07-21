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


    @BeforeEach
    void setUp() {
        deathCertificateUntrackedFieldsValidator = new DeathCertificateUntrackedFieldsValidatorImpl(validateTwoFieldTypesMock);
        deathCertificateCommand = new DeathCertificateCommandImpl();
        spouse = GetRandomPerson();
        father = GetRandomPerson();
        whereDied = GetRandomPlace();
        untrackedSpouse = GetRandomString();
        untrackedFather = GetRandomString();
        untrackedWhereDied = GetRandomString();

        deathCertificateCommand.setSpouse(spouse);
        deathCertificateCommand.setUntrackedSpouse(untrackedSpouse);
        deathCertificateCommand.setFather(father);
        deathCertificateCommand.setUntrackedFather(untrackedFather);

        deathCertificateCommand.setWhereDied(whereDied);
        deathCertificateCommand.setUntrackedWhereDied(untrackedWhereDied);
    }

    @Test
    void theTestAreRunTest() {
        deathCertificateUntrackedFieldsValidator.validate(deathCertificateCommand, bindingResultMock);
        verify(validateTwoFieldTypesMock).validatePersonAndUntrackedPerson(spouse, untrackedSpouse, "spouse", "untrackedSpouse",
                "One and only one spouse and untracked spouse must be specified.", bindingResultMock);
        verify(validateTwoFieldTypesMock).validatePersonAndUntrackedPerson(father, untrackedFather, "father", "untrackedFather",
                "One and only one father and untracked father must be specified.", bindingResultMock);
        verify(validateTwoFieldTypesMock).validatePlaceAndUntrackedPlace(whereDied, untrackedWhereDied, "whereDied", "untrackedWhereDied",
                "One and only one where died and untracked where died must be specified.", bindingResultMock);
    }


}