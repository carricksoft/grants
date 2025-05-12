/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:15. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class CensusEntryCommandPartTwoTest {

    private CensusEntryCommand command;

    @BeforeEach
    void setUp() {
        command = new CensusEntryCommandImpl();
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        command.setId(id);
        assertEquals(id, command.getId());
    }


    @Test
    void getNotesTest() {
        assertNull(command.getNotes());
    }

    @Test
    void setNotesTest() {
        String notes = GetRandomString();
        command.setNotes(notes);
        assertEquals(notes, command.getNotes());
    }

    @Test
    void getCensusTest() {
        assertNull(command.getCensus());
    }

    @Test
    void setCensusTest() {
        Census census = GetRandomCensus();
        command.setCensus(census);
        assertEquals(census, command.getCensus());
    }

    @Test
    void getPersonTest() {
        assertNull(command.getPerson());
    }

    @Test
    void setPersonTest() {
        Person person = GetRandomPerson();
        command.setPerson(person);
        assertEquals(person, command.getPerson());
    }

    @Test
    void getAgeTest() {
        assertNull(command.getAge());
    }

    @Test
    void setAgeTest() {
        String age = GetRandomString();
        command.setAge(age);
        assertEquals(age, command.getAge());
    }

    @Test
    void getWhereBornTest() {
        assertNull(command.getWhereBorn());
    }

    @Test
    void setWhereBornTest() {
        String whereBorn = GetRandomString();
        command.setWhereBorn(whereBorn);
        assertEquals(whereBorn, command.getWhereBorn());
    }




}