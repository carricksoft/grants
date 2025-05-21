/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:54. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.people;

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

class PersonCommandReverseRelationshipSettersTest {

    PersonCommand command;

    @BeforeEach
    void setUp() {
        command = new PersonCommandImpl();
    }

    @Test
    void setBirthCertificatesTest() {
        List<BirthCertificate> certificates = new ArrayList<>();
        certificates.add(new BirthCertificate());
        command.setBirthCertificates(certificates);
        assertEquals(certificates, command.getBirthCertificates());
    }

    @Test
    void getDeathCertificatesTest() {
        List<DeathCertificate> certificates = new ArrayList<>();
        certificates.add(new DeathCertificate());
        command.setDeathCertificates(certificates);
        assertEquals(certificates, command.getDeathCertificates());
    }

    @Test
    void getMarriageCertificatesTest() {
        List<MarriageCertificate> certificates = new ArrayList<>();
        certificates.add(new MarriageCertificate());
        command.setMarriageCertificates(certificates);
        assertEquals(certificates, command.getMarriageCertificates());
    }

    @Test
    void getDivorceCertificatesTest() {
        List<DivorceCertificate> certificates = new ArrayList<>();
        certificates.add(new DivorceCertificate());
        command.setDivorceCertificates(certificates);
        assertEquals(certificates, command.getDivorceCertificates());
    }

    @Test
    void getCensusEntriesTest() {
        List<CensusEntry> certificates = new ArrayList<>();
        certificates.add(new CensusEntry());
        command.setCensusEntries(certificates);
        assertEquals(certificates, command.getCensusEntries());
    }

    @Test
    void getPersonImagesTest() {
        List<PersonImage> certificates = new ArrayList<>();
        certificates.add(new PersonImage());
        command.setPersonImages(certificates);
        assertEquals(certificates, command.getPersonImages());
    }

    @Test
    void getPersonTextsTest() {
        List<PersonText> certificates = new ArrayList<>();
        certificates.add(new PersonText());
        command.setPersonTexts(certificates);
        assertEquals(certificates, command.getPersonTexts());
    }
}