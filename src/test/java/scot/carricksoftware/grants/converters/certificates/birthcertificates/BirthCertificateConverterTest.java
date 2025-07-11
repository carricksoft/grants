/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.birthcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class BirthCertificateConverterTest {

    private BirthCertificateConverter converter;

    @BeforeEach
    void setUp() {
        converter = new BirthCertificateConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        Person person = GetRandomPerson();
        BirthCertificate source = new BirthCertificate();
        Organisation certificateSource = GetRandomOrganisation();
        String certificateNumber = GetRandomString();
        String certificateDate = GetRandomString();
        CertificateType certificateType = CertificateType.EXTRACT;
        Organisation registrationAuthority = GetRandomOrganisation();
        String volume = GetRandomString();
        String number = GetRandomString();
        Sex sex = Sex.MALE;
        String whenBorn = GetRandomString();
        String untrackedWhereBorn = GetRandomString();
        Person father = GetRandomPerson();
        Person mother = GetRandomPerson();
        String dateAndPlaceOfMarriage = GetRandomString();
        String fatherRank = GetRandomString();
        String untrackedFather = GetRandomString();
        Place whereBorn = GetRandomPlace();
        Person informant = GetRandomPerson();
        String untrackedInformant = GetRandomString();
        String informantQualifier = GetRandomString();
        String whenRegistered = GetRandomString();
        String whereRegistered = GetRandomString();
        Place fatherUsualResidence = GetRandomPlace();
        String untrackedFatherUsualResidence = GetRandomString();
        String informantResidence = GetRandomString();
        Place motherUsualResidence = GetRandomPlace();
        String untrackedMotherUsualResidence = GetRandomString();


        source.setId(id);
        source.setNewBorn(person);
        source.setCertificateNumber(certificateNumber);
        source.setCertificateDate(certificateDate);
        source.setCertificateSource(certificateSource);
        source.setCertificateType(certificateType);
        source.setVolume(volume);
        source.setNumber(number);
        source.setRegistrationAuthority(registrationAuthority);
        source.setSex(sex);
        source.setWhenBorn(whenBorn);
        source.setWhereBorn(whereBorn);
        source.setUntrackedWhereBorn(untrackedWhereBorn);
        source.setFather(father);
        source.setMother(mother);
        source.setDateAndPlaceOfMarriage(dateAndPlaceOfMarriage);
        source.setFatherRank(fatherRank);
        source.setUntrackedFather(untrackedFather);
        source.setInformant(informant);
        source.setUntrackedInformant(untrackedInformant);
        source.setInformantQualification(informantQualifier);
        source.setWhenRegistered(whenRegistered);
        source.setWhereRegistered(whereRegistered);
        source.setFatherUsualResidence(fatherUsualResidence);
        source.setUntrackedFatherUsualResidence(untrackedFatherUsualResidence);
        source.setInformantResidence(informantResidence);
        source.setMotherUsualResidence(motherUsualResidence);
        source.setUntrackedMotherUsualResidence(untrackedMotherUsualResidence);

        BirthCertificateCommand target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(person, target.getNewBorn());
        assertEquals(certificateNumber, target.getCertificateNumber());
        assertEquals(certificateDate, target.getCertificateDate());
        assertEquals(certificateSource, target.getCertificateSource());
        assertEquals(certificateType, target.getCertificateType());
        assertEquals(volume, target.getVolume());
        assertEquals(number, target.getNumber());
        assertEquals(registrationAuthority, target.getRegistrationAuthority());
        assertEquals(sex, target.getSex());
        assertEquals(whereBorn, target.getWhereBorn());
        assertEquals(untrackedWhereBorn, target.getUntrackedWhereBorn());
        assertEquals(whenBorn, target.getWhenBorn());
        assertEquals(dateAndPlaceOfMarriage, target.getDateAndPlaceOfMarriage());
        assertEquals(fatherRank, target.getFatherRank());
        assertEquals(untrackedFather, target.getUntrackedFather());
        assertEquals(father, target.getFather());
        assertEquals(mother, target.getMother());
        assertEquals(informant, target.getInformant());
        assertEquals(untrackedInformant, target.getUntrackedInformant());
        assertEquals(informantQualifier, target.getInformantQualification());
        assertEquals(whenRegistered, target.getWhenRegistered());
        assertEquals(whereRegistered, target.getWhereRegistered());
        assertEquals(fatherUsualResidence, target.getFatherUsualResidence());
        assertEquals(untrackedFatherUsualResidence, target.getUntrackedFatherUsualResidence());
        assertEquals(informantResidence, target.getInformantResidence());
        assertEquals(motherUsualResidence, target.getMotherUsualResidence());
        assertEquals(untrackedMotherUsualResidence, target.getUntrackedMotherUsualResidence());
    }
}