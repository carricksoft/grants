/*
 * Copyright (c)  21 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

class CensusEntryCommandTest {

    CensusEntryCommand censusEntryCommand;

    @BeforeEach
    void setUp() {
        censusEntryCommand = new CensusEntryCommand();
    }

    @Test
    void getCensusTest() {
        assertNull(censusEntryCommand.getCensus());
    }

    @Test
    void setCensusTest() {
        Census census = GetRandomCensus();
        censusEntryCommand.setCensus(census);
        assertEquals(census, censusEntryCommand.getCensus());
    }

    @Test
    void getPersonTest() {
        assertNull(censusEntryCommand.getPerson());
    }

    @Test
    void setPersonTest() {
        Person person = GetRandomPerson();
        censusEntryCommand.setPerson(person);
        assertEquals(person, censusEntryCommand.getPerson());
    }

    @Test
    void getOtherPersonTest() {
        assertNull(censusEntryCommand.getOtherPerson());
    }

    @Test
    void setOtherPersonTest() {
        String OtherPerson = GetRandomString();
        censusEntryCommand.setOtherPerson(OtherPerson);
        assertEquals(OtherPerson, censusEntryCommand.getOtherPerson());
    }

    @Test
    void testToStringTest() {
        Person person = GetRandomPerson();
        Census census = GetRandomCensus();
        String otherPerson = GetRandomString();

        censusEntryCommand.setPerson(person);
        censusEntryCommand.setCensus(census);
        censusEntryCommand.setOtherPerson(otherPerson);

        String requiredResult = census +", (" + person +"), (" + otherPerson +")";

        assertEquals(requiredResult, censusEntryCommand.toString());

    }
}