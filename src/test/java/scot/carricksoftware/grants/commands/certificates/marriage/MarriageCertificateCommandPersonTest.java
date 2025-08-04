/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.marriage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;


class MarriageCertificateCommandPersonTest {

    private MarriageCertificateCommand marriageCertificateCommand;
    private Person person;

    @BeforeEach
    void setUp() {
        marriageCertificateCommand = new MarriageCertificateCommandImpl();
        person = GetRandomPerson();
    }

    @Test
    void getBrideTest() {
        assertNull(marriageCertificateCommand.getBride());
    }

    @Test
    void setBrideTest() {
        marriageCertificateCommand.setBride(person);
        assertEquals(person, marriageCertificateCommand.getBride());
    }

    @Test
    void getGroomTest() {
        assertNull(marriageCertificateCommand.getGroom());
    }

    @Test
    void setGroomTest() {
        marriageCertificateCommand.setGroom(person);
        assertEquals(person, marriageCertificateCommand.getGroom());
    }

    @Test
    void getBrideFatherTest() {
        assertNull(marriageCertificateCommand.getBrideFather());
    }

    @Test
    void setBrideFatherTest() {
        marriageCertificateCommand.setBrideFather(person);
        assertEquals(person, marriageCertificateCommand.getBrideFather());
    }

    @Test
    void getGroomFatherTest() {
        assertNull(marriageCertificateCommand.getGroomFather());
    }

    @Test
    void setGroomFatherTest() {
        marriageCertificateCommand.setGroomFather(person);
        assertEquals(person, marriageCertificateCommand.getGroomFather());
    }

    @Test
    void getFirstWitnessTest() {
        assertNull(marriageCertificateCommand.getFirstWitness());
    }

    @Test
    void setFirstWitnessTest() {
        marriageCertificateCommand.setFirstWitness(person);
        assertEquals(person, marriageCertificateCommand.getFirstWitness());
    }

    @Test
    void getSecondWitnessTest() {
        assertNull(marriageCertificateCommand.getSecondWitness());
    }

    @Test
    void setSecondWitnessTest() {
        marriageCertificateCommand.setSecondWitness(person);
        assertEquals(person, marriageCertificateCommand.getSecondWitness());
    }


}