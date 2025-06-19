/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 19:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.birthcertificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
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

class BirthCertificateCommandConverterTest {

    private BirthCertificateCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new BirthCertificateCommandConverterImpl();
    }

    @Test
    void convertTest() {
        String untrackedWhereBorn = GetRandomString();
        Long id = GetRandomLong();
        Place whereBorn = GetRandomPlace();
        Person person = GetRandomPerson();
        BirthCertificateCommand source = new BirthCertificateCommandImpl();
        Organisation issuedAt = GetRandomOrganisation();
        String certificateNumber = GetRandomString();
        String certificateDate = GetRandomString();
        CertificateType certificateType = CertificateType.EXTRACT;
        Organisation registrationAuthority = GetRandomOrganisation();
        String volume = GetRandomString();
        String number = GetRandomString();
        Sex sex = Sex.MALE;
        String whenBorn = GetRandomString();
        Person father = GetRandomPerson();
        Person mother = GetRandomPerson();
        String dateAndPlaceOfMarriage = GetRandomString();
        String fatherRank = GetRandomString();
        String untrackedFather = GetRandomString();


        source.setId(id);
        source.setNewBorn(person);
        source.setCertificateNumber(certificateNumber);
        source.setCertificateDate(certificateDate);
        source.setCertificateSource(issuedAt);
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


        BirthCertificate target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(person, target.getNewBorn());
        assertEquals(certificateNumber, target.getCertificateNumber());
        assertEquals(certificateDate, target.getCertificateDate());
        assertEquals(issuedAt, target.getCertificateSource());
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
    }
}