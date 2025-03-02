/*
 * Copyright (c)  24 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.census;

import org.junit.Before;
import org.junit.Test;
import scot.carricksoftware.grants.domains.people.Person;

import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCensus;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

public class CensusEntryTest {
    CensusEntry censusEntry;

    @Before
    public void setUp() {
        censusEntry = new CensusEntry();
    }

    @Test
    public void getCensusTest() {
        assertNull(censusEntry.getCensus());
    }

    @Test
    public void setCensusTest() {
        Census census = GetRandomCensus();
        censusEntry.setCensus(census);
        assertEquals(census, censusEntry.getCensus());
    }

    @Test
    public void getPersonTest() {
        assertNull(censusEntry.getPerson());
    }

    @Test
    public void setPersonTest() {
        Person person = GetRandomPerson();
        censusEntry.setPerson(person);
        assertEquals(person, censusEntry.getPerson());
    }

    @Test
    public void getOtherPersonTest() {
        assertNull(censusEntry.getOtherPerson());
    }

    @Test
    public void setOtherPersonTest() {
        String OtherPerson = GetRandomString();
        censusEntry.setOtherPerson(OtherPerson);
        assertEquals(OtherPerson, censusEntry.getOtherPerson());
    }

    @Test
    public void toStringTest() {
        Person person = GetRandomPerson();
        Census census = GetRandomCensus();
        String otherPerson = GetRandomString();

        censusEntry.setPerson(person);
        censusEntry.setCensus(census);
        censusEntry.setOtherPerson(otherPerson);

        String requiredResult = census + ", (" + person + "), (" + otherPerson + ")";

        assertEquals(requiredResult, censusEntry.toString());

    }
}