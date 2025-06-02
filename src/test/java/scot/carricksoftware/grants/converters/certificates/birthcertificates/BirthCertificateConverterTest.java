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
import scot.carricksoftware.grants.enums.censusentry.CensusEntrySex;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;

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
        CensusEntrySex sex = CensusEntrySex.MALE;
        String whenBorn = GetRandomString();
        String whereBorn = GetRandomString();

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
        assertEquals(whenBorn, target.getWhenBorn());

    }
}