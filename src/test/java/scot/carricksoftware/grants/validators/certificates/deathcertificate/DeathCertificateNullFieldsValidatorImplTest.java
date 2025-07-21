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
import scot.carricksoftware.grants.validators.helpers.ValidateDateTypes;
import scot.carricksoftware.grants.validators.helpers.ValidateTypesImpl;

import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class DeathCertificateNullFieldsValidatorImplTest {

    DeathCertificateNullFieldsValidator deathCertificateNullFieldsValidator;

    @Mock
    private ValidateTypesImpl validateTypesMock;

    @Mock
    private ValidateDateTypes validateDateTypesMock;

    @Mock
    private BindingResult bindingResultMock;

    DeathCertificateCommand deathCertificateCommand;
    Person deceased;
    String certificateNumber;
    String volume;
    String number;
    String causeOfDeath;
    String informantQualification;

    @BeforeEach
    void setUp() {
        deathCertificateNullFieldsValidator = new DeathCertificateNullFieldsValidatorImpl(validateTypesMock, validateDateTypesMock);
        deathCertificateCommand = new DeathCertificateCommandImpl();
        deceased = GetRandomPerson();
        certificateNumber = GetRandomString();
        volume = GetRandomString();
        number = GetRandomString();
        causeOfDeath = GetRandomString();
        informantQualification = GetRandomString();
        deathCertificateCommand.setDeceased(deceased);
        deathCertificateCommand.setCertificateNumber(certificateNumber);
        deathCertificateCommand.setVolume(volume);
        deathCertificateCommand.setNumber(number);
        deathCertificateCommand.setCauseOfDeath(causeOfDeath);
        deathCertificateCommand.setInformantQualification(informantQualification);
    }

    @Test
    void validateTypesIsCalledTest() {
        deathCertificateNullFieldsValidator.validate(deathCertificateCommand, bindingResultMock);

        verify(validateTypesMock).validatePerson(deceased, "deceased", "The deceased cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(certificateNumber, "certificateNumber", "The certificate number cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(volume, "volume", "The volume cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(number, "number", "The number cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(causeOfDeath, "causeOfDeath", "The cause of death should be specified.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(informantQualification, "informantQualification", "The informant qualification cannot be null.", bindingResultMock);
    }


}