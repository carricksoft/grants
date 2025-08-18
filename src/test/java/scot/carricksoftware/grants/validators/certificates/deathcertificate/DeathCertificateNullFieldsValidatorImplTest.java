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
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.validators.helpers.ValidateTypesImpl;

import static org.mockito.Mockito.verify;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;

@ExtendWith(MockitoExtension.class)
class DeathCertificateNullFieldsValidatorImplTest {

    @SuppressWarnings("unused")
    DeathCertificateNullFieldsValidator deathCertificateNullFieldsValidator;

    @Mock
    private ValidateTypesImpl validateTypesMock;


    @Mock
    private BindingResult bindingResultMock;

    @SuppressWarnings("unused")
    DeathCertificateCommand deathCertificateCommand;
    private Person deceased;
    private String volume;
    private String number;
    private String causeOfDeath;
    private String informantQualification;
    private String certificateType;
    private final Sex sex = Sex.FEMALE;
    private Organisation certificateSource;
    @SuppressWarnings("unused")
    private Organisation registrationAuthority;

    @BeforeEach
    void setUp() {
        deathCertificateNullFieldsValidator = new DeathCertificateNullFieldsValidatorImpl(validateTypesMock);
        deathCertificateCommand = new DeathCertificateCommandImpl();

        deceased = GetRandomPerson();
        String certificateNumber = GetRandomString();
        volume = GetRandomString();
        number = GetRandomString();
        causeOfDeath = GetRandomString();
        informantQualification = GetRandomString();
        certificateSource = GetRandomOrganisation();
        certificateType = GetRandomString();
        deathCertificateCommand.setDeceased(deceased);
        deathCertificateCommand.setCertificateNumber(certificateNumber);
        deathCertificateCommand.setVolume(volume);
        deathCertificateCommand.setNumber(number);
        deathCertificateCommand.setCauseOfDeath(causeOfDeath);
        deathCertificateCommand.setInformantQualification(informantQualification);
        deathCertificateCommand.setSex(sex);
        deathCertificateCommand.setCertificateSource(certificateSource);
        deathCertificateCommand.setRegistrationAuthority(registrationAuthority);
    }

    @Test
    void validateTypesIsCalledTest() {
        deathCertificateNullFieldsValidator.validate(deathCertificateCommand, bindingResultMock);

        verify(validateTypesMock).validatePerson(deceased, "deceased", "The deceased cannot be null.", bindingResultMock);
        verify(validateTypesMock).validatePerson(deceased, "deceased", "The deceased cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(certificateType, "certificateNumber", "The certificate number cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(volume, "volume", "The volume cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(number, "number", "The number cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(causeOfDeath, "causeOfDeath", "The cause of death should be specified.", bindingResultMock);
        verify(validateTypesMock).validateNullOrEmptyString(informantQualification, "informantQualification", "The informant qualification cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateSex(sex, "sex", "Sex cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateOrganisation(certificateSource, "certificateSource", "The certificate source cannot be null.", bindingResultMock);
        verify(validateTypesMock).validateOrganisation(registrationAuthority, "registrationAuthority", "The registration authority cannot be null.", bindingResultMock);
    }

}