/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.birth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;


class BirthCertificateParentsTest {

    private BirthCertificateCommand command;

    @BeforeEach
    void setUp() {
        command = new BirthCertificateCommandImpl();
    }

    @Test
    void getFatherTest() {
        assertNull(command.getFather());
    }

    @Test
    void setFatherTest() {
        Person father = GetRandomPerson();
        command.setFather(father);
        assertEquals(father, command.getFather());
    }

    @Test
    void getUntrackedFatherTest() {
        assertNull(command.getUntrackedFather());
    }

    @Test
    void setUntrackedFatherTest() {
        String untrackedFather = GetRandomString();
        command.setUntrackedFather(untrackedFather);
        assertEquals(untrackedFather, command.getUntrackedFather());
    }

    @Test
    void getFatherRankTest() {
        assertNull(command.getFatherRank());
    }

    @Test
    void setFatherRankTest() {
        String fatherRank = GetRandomString();
        command.setFatherRank(fatherRank);
        assertEquals(fatherRank, command.getFatherRank());
    }

    @Test
    void MotherTest() {
        assertNull(command.getMother());
    }

    @Test
    void setMotherTest() {
        Person mother = GetRandomPerson();
        command.setMother(mother);
        assertEquals(mother, command.getMother());
    }

    @Test
    void getDateAndPlaceOfMarriageTest() {
        assertNull(command.getDateAndPlaceOfMarriage());
    }

    @Test
    void setDateAndPLaceOfMarriageTest() {
        String dateAndPLaceOfMarriage = GetRandomString();
        command.setDateAndPlaceOfMarriage(dateAndPLaceOfMarriage);
        assertEquals(dateAndPLaceOfMarriage, command.getDateAndPlaceOfMarriage());
    }


}