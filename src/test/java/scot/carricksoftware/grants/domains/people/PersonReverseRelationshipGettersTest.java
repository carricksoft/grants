/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:54. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonReverseRelationshipGettersTest {

    Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void getBirthCertificatesTest() {
        assertTrue(person.getBirthCertificates().isEmpty());
    }


    @Test
    void getDeathCertificatesTest() {
        assertTrue(person.getDeathCertificates().isEmpty());
    }

    @Test
    void getMarriageCertificatesTest() {
        assertTrue(person.getMarriageCertificates().isEmpty());
    }

    @Test
    void getDivorceCertificatesTest() {
        assertTrue(person.getDivorceCertificates().isEmpty());
    }

    @Test
    void getCensusEntriesTest() {
        assertTrue(person.getCensusEntries().isEmpty());
    }

    @Test
    void getPersonImagesTest() {
        assertTrue(person.getPersonImages().isEmpty());
    }

    @Test
    void getPersonTextsTest() {
        assertTrue(person.getPersonTexts().isEmpty());
    }
}