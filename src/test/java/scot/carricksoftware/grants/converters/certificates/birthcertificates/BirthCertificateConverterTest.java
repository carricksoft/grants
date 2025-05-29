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
import scot.carricksoftware.grants.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
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
        Place issuedAt = GetRandomPlace();
        String certificateNumber = GetRandomString();
        String certificateDate = GetRandomString();

        source.setId(id);
        source.setNewBorn(person);
        source.setCertificateNumber(certificateNumber);
        source.setCertificateDate(certificateDate);
        source.setCertificateIssuedAt(issuedAt);


        BirthCertificateCommand target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(person, target.getNewBorn());
        assertEquals(certificateNumber, target.getCertificateNumber());
        assertEquals(certificateDate, target.getCertificateDate());
        assertEquals(issuedAt, target.getCertificateIssuedAt());

    }
}