/*
 * Copyright (c)  21 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.census;


import org.junit.Before;
import org.junit.Test;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

public class CensusEntryCommandTest {

    CensusEntryCommand censusEntryCommand;

    @Before
    public void setUp() {
        censusEntryCommand = new CensusEntryCommand();
    }

    @Test
    public void getIdTest() {
        assertNull(censusEntryCommand.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        censusEntryCommand.setId(id);
        assertEquals(id, censusEntryCommand.getId());
    }

    @Test
    public void getCensusTest() {
        assertNull(censusEntryCommand.getCensus());
    }

    @Test
    public void setCensusTest() {
        Census census = GetRandomCensus();
        censusEntryCommand.setCensus(census);
        assertEquals(census, censusEntryCommand.getCensus());
    }

    @Test
    public void getPersonTest() {
        assertNull(censusEntryCommand.getPerson());
    }

    @Test
    public void setPersonTest() {
        Person person = GetRandomPerson();
        censusEntryCommand.setPerson(person);
        assertEquals(person, censusEntryCommand.getPerson());
    }

    @Test
    public void getOtherPersonTest() {
        assertNull(censusEntryCommand.getOtherPerson());
    }

    @Test
    public void setOtherPersonTest() {
        String OtherPerson = GetRandomString();
        censusEntryCommand.setOtherPerson(OtherPerson);
        assertEquals(OtherPerson, censusEntryCommand.getOtherPerson());
    }

    @Test
    public void testToStringTest() {
        Person person = GetRandomPerson();
        Census census = GetRandomCensus();
        String otherPerson = GetRandomString();

        censusEntryCommand.setPerson(person);
        censusEntryCommand.setCensus(census);
        censusEntryCommand.setOtherPerson(otherPerson);

        String requiredResult = census + ", (" + person + "), (" + otherPerson + ")";

        assertEquals(requiredResult, censusEntryCommand.toString());

    }
}