/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:20. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

class BirthCertificateTest {

    private BirthCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new BirthCertificate();
    }

    @Test
    public void getIdTest() {
        assertNull(certificate.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        certificate.setId(id);
        assertEquals(id, certificate.getId());
    }

    @Test
    void getNewBornTest() {
        assertNull(certificate.getId());
    }

    @Test
    void setNewBornTest() {
        Person person = GetRandomPerson();
        certificate.setNewBorn(person);
        assertEquals(person, certificate.getNewBorn());
    }

    @Test
    void getCertificateNumberTest() {
        assertNull(certificate.getCertificateNumber());
    }

    @Test
    void setCertificateNumberTest() {
        String certificateNumber = GetRandomString();
        certificate.setCertificateNumber(certificateNumber);
        assertEquals(certificateNumber, certificate.getCertificateNumber());
    }

    @Test
    void getCertificateDateTest() {
        assertNull(certificate.getCertificateDate());
    }

    @Test
    void setCertificateDateTest() {
        String certificateDate = GetRandomString();
        certificate.setCertificateDate(certificateDate);
        assertEquals(certificateDate, certificate.getCertificateDate());
    }

    @Test
    void getCertificateIssuedAtTest() {
        Place place = GetRandomPlace();
        certificate.setCertificateIssuedAt(place);
        assertEquals(place, certificate.getCertificateIssuedAt());
    }
}