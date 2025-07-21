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
import scot.carricksoftware.grants.validators.helpers.ValidateTwoFieldTypes;

import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

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


    @BeforeEach
    void setUp() {
        deathCertificateUntrackedFieldsValidator = new DeathCertificateUntrackedFieldsValidatorImpl(validateTwoFieldTypesMock);
        deathCertificateCommand = new DeathCertificateCommandImpl();
        spouse = GetRandomPerson();
        untrackedSpouse = GetRandomString();

        deathCertificateCommand.setSpouse(spouse);
        deathCertificateCommand.setUntrackedSpouse(untrackedSpouse);
    }

    @Test
    void theTestAreRunTest() {
        deathCertificateUntrackedFieldsValidator.validate(deathCertificateCommand, bindingResultMock);
        verify(validateTwoFieldTypesMock).validatePersonAndUntrackedPerson(spouse, untrackedSpouse, "spouse", "untrackedSpouse",
                "One and only one spouse and untracked spouse must be specified.", bindingResultMock);
    }


}