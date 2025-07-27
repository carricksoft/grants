/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.certificates.CertificateType;
import scot.carricksoftware.grants.enums.general.Sex;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

@ExtendWith(MockitoExtension.class)
class DeathCertificateCommandConverterTest {

    private DeathCertificateCommandConverter converter;
    private DeathCertificateCommand deathCertificateCommand;

    @Mock
    private DeathCertificateCommandMilitaryConverter deathCertificateCommandMilitaryConverterMock;

    @BeforeEach
    void setUp() {
        converter = new DeathCertificateCommandConverterImpl(deathCertificateCommandMilitaryConverterMock);
        deathCertificateCommand = new DeathCertificateCommandImpl();
    }

    @Test
    void converterTest() {
        String age = GetRandomString();
        String causeOfDeath = GetRandomString();
        String certificateDate = GetRandomString();
        String certificateNumber = GetRandomString();
        Organisation certificateSource = GetRandomOrganisation();
        CertificateType certificateType = CertificateType.EXTRACT;
        Person deceased = GetRandomPerson();
        Person father = GetRandomPerson();
        String fatherOccupation = GetRandomString();
        Long id = GetRandomLong();
        Person informant = GetRandomPerson();
        String informantAddress = GetRandomString();
        String informantQualification = GetRandomString();
        String maritalStatus = GetRandomString();
        Person mother = GetRandomPerson();
        String motherOccupation = GetRandomString();
        String number = GetRandomString();
        String occupation = GetRandomString();
        Organisation registrationAuthority = GetRandomOrganisation();
        Sex sex = Sex.MALE;
        Person spouse = GetRandomPerson();
        String spouseOccupation = GetRandomString();
        String untrackedFather = GetRandomString();
        String untrackedInformant = GetRandomString();
        String untrackedMother = GetRandomString();
        String untrackedSpouse = GetRandomString();
        String untrackedUsualResidence = GetRandomString();
        String untrackedWhereDied = GetRandomString();
        Place usualResidence = GetRandomPlace();
        String volume = GetRandomString();
        String whenBorn = GetRandomString();
        String whenDied = GetRandomString();
        String whenRegistered = GetRandomString();
        Place whereDied = GetRandomPlace();
        String whereRegistered = GetRandomString();

        deathCertificateCommand.setAge(age);
        deathCertificateCommand.setCauseOfDeath(causeOfDeath);
        deathCertificateCommand.setCertificateDate(certificateDate);
        deathCertificateCommand.setCertificateNumber(certificateNumber);
        deathCertificateCommand.setCertificateSource(certificateSource);
        deathCertificateCommand.setCertificateType(certificateType);
        deathCertificateCommand.setDeceased(deceased);
        deathCertificateCommand.setFather(father);
        deathCertificateCommand.setFatherOccupation(fatherOccupation);
        deathCertificateCommand.setId(id);
        deathCertificateCommand.setInformant(informant);
        deathCertificateCommand.setInformantAddress(informantAddress);
        deathCertificateCommand.setInformantQualification(informantQualification);
        deathCertificateCommand.setMaritalStatus(maritalStatus);
        deathCertificateCommand.setMother(mother);
        deathCertificateCommand.setMotherOccupation(motherOccupation);
        deathCertificateCommand.setNumber(number);
        deathCertificateCommand.setOccupation(occupation);
        deathCertificateCommand.setRegistrationAuthority(registrationAuthority);
        deathCertificateCommand.setSex(sex);
        deathCertificateCommand.setSpouse(spouse);
        deathCertificateCommand.setSpouseOccupation(spouseOccupation);
        deathCertificateCommand.setUntrackedFather(untrackedFather);
        deathCertificateCommand.setUntrackedInformant(untrackedInformant);
        deathCertificateCommand.setUntrackedMother(untrackedMother);
        deathCertificateCommand.setUntrackedSpouse(untrackedSpouse);
        deathCertificateCommand.setUntrackedUsualResidence(untrackedUsualResidence);
        deathCertificateCommand.setUntrackedWhereDied(untrackedWhereDied);
        deathCertificateCommand.setUsualResidence(usualResidence);
        deathCertificateCommand.setVolume(volume);
        deathCertificateCommand.setWhenBorn(whenBorn);
        deathCertificateCommand.setWhenDied(whenDied);
        deathCertificateCommand.setWhenRegistered(whenRegistered);
        deathCertificateCommand.setWhereDied(whereDied);
        deathCertificateCommand.setWhereRegistered(whereRegistered);
        
        DeathCertificate target = converter.convert(deathCertificateCommand);

        assertNotNull(target);
        assertEquals(age,target.getAge());
        assertEquals(causeOfDeath,target.getCauseOfDeath());
        assertEquals(certificateDate,target.getCertificateDate());
        assertEquals(certificateNumber,target.getCertificateNumber());
        assertEquals(certificateSource,target.getCertificateSource());
        assertEquals(certificateType,target.getCertificateType());
        assertEquals(deceased,target.getDeceased());
        assertEquals(father,target.getFather());
        assertEquals(fatherOccupation,target.getFatherOccupation());
        assertEquals(id,target.getId());
        assertEquals(informant,target.getInformant());
        assertEquals(informantAddress,target.getInformantAddress());
        assertEquals(informantQualification,target.getInformantQualification());
        assertEquals(maritalStatus,target.getMaritalStatus());
        assertEquals(mother,target.getMother());
        assertEquals(motherOccupation,target.getMotherOccupation());
        assertEquals(number,target.getNumber());
        assertEquals(occupation,target.getOccupation());
        assertEquals(registrationAuthority,target.getRegistrationAuthority());
        assertEquals(sex,target.getSex());
        assertEquals(spouse,target.getSpouse());
        assertEquals(spouseOccupation,target.getSpouseOccupation());
        assertEquals(untrackedFather,target.getUntrackedFather());
        assertEquals(untrackedInformant,target.getUntrackedInformant());
        assertEquals(untrackedMother,target.getUntrackedMother());
        assertEquals(untrackedSpouse,target.getUntrackedSpouse());
        assertEquals(untrackedUsualResidence,target.getUntrackedUsualResidence());
        assertEquals(untrackedWhereDied,target.getUntrackedWhereDied());
        assertEquals(usualResidence,target.getUsualResidence());
        assertEquals(volume,target.getVolume());
        assertEquals(whenBorn,target.getWhenBorn());
        assertEquals(whenDied,target.getWhenDied());
        assertEquals(whenRegistered,target.getWhenRegistered());
        assertEquals(whereDied,target.getWhereDied());
        assertEquals(whereRegistered,target.getWhereRegistered());

    }
}