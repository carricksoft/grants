/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates.birth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;


class BirthCertificateParentsTest {

    private BirthCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new BirthCertificate();
    }

    @Test
    void getFatherTest() {
        assertNull(certificate.getFather());
    }

    @Test
    void setFatherTest() {
        Person father = GetRandomPerson();
        certificate.setFather(father);
        assertEquals(father, certificate.getFather());
    }

    @Test
    void getUntrackedFatherTest() {
        assertNull(certificate.getUntrackedFather());
    }

    @Test
    void setUntrackedFatherTest() {
        String untrackedFather = GetRandomString();
        certificate.setUntrackedFather(untrackedFather);
        assertEquals(untrackedFather, certificate.getUntrackedFather());
    }

    @Test
    void getFatherRankTest() {
        assertNull(certificate.getFatherRank());
    }

    @Test
    void setFatherRankTest() {
        String fatherRank = GetRandomString();
        certificate.setFatherRank(fatherRank);
        assertEquals(fatherRank, certificate.getFatherRank());
    }

    @Test
    void MotherTest() {
        assertNull(certificate.getMother());
    }

    @Test
    void setMotherTest() {
        Person mother = GetRandomPerson();
        certificate.setMother(mother);
        assertEquals(mother, certificate.getMother());
    }

    @Test
    void getDateAndPlaceOfMarriageTest() {
        assertNull(certificate.getDateAndPlaceOfMarriage());
    }

    @Test
    void setDateAndPLaceOfMarriageTest() {
        String dateAndPLaceOfMarriage = GetRandomString();
        certificate.setDateAndPlaceOfMarriage(dateAndPLaceOfMarriage);
        assertEquals(dateAndPLaceOfMarriage, certificate.getDateAndPlaceOfMarriage());
    }


}