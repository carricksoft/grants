/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:54. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.domains.images.PersonImage;
import scot.carricksoftware.grants.domains.text.PersonText;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonReverseRelationshipSettersTest {

    Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void setBirthCertificatesTest() {
        List<BirthCertificate> certificates = new ArrayList<>();
        certificates.add(new BirthCertificate());
        person.setBirthCertificates(certificates);
        assertEquals(certificates, person.getBirthCertificates());
    }

    @Test
    void getDeathCertificatesTest() {
        List<DeathCertificate> certificates = new ArrayList<>();
        certificates.add(new DeathCertificate());
        person.setDeathCertificates(certificates);
        assertEquals(certificates, person.getDeathCertificates());
    }

    @Test
    void getMarriageCertificatesTest() {
        List<MarriageCertificate> certificates = new ArrayList<>();
        certificates.add(new MarriageCertificate());
        person.setMarriageCertificates(certificates);
        assertEquals(certificates, person.getMarriageCertificates());
    }

    @Test
    void getDivorceCertificatesTest() {
        List<DivorceCertificate> certificates = new ArrayList<>();
        certificates.add(new DivorceCertificate());
        person.setDivorceCertificates(certificates);
        assertEquals(certificates, person.getDivorceCertificates());
    }

    @Test
    void getCensusEntriesTest() {
        List<CensusEntry> certificates = new ArrayList<>();
        certificates.add(new CensusEntry());
        person.setCensusEntries(certificates);
        assertEquals(certificates, person.getCensusEntries());
    }

    @Test
    void getPersonImagesTest() {
        List<PersonImage> certificates = new ArrayList<>();
        certificates.add(new PersonImage());
        person.setPersonImages(certificates);
        assertEquals(certificates, person.getPersonImages());
    }

    @Test
    void getPersonTextsTest() {
        List<PersonText> certificates = new ArrayList<>();
        certificates.add(new PersonText());
        person.setPersonTexts(certificates);
        assertEquals(certificates, person.getPersonTexts());
    }
}