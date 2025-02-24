/*
 * Copyright (c)  24 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.people.Person;

import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCensus;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

class CensusEntryTest {
    CensusEntry censusEntry;

    @BeforeEach
    void setUp() {
        censusEntry = new CensusEntry();
    }

    @Test
    void getCensusTest() {
        assertNull(censusEntry.getCensus());
    }

    @Test
    void setCensusTest() {
        Census census = GetRandomCensus();
        censusEntry.setCensus(census);
        assertEquals(census, censusEntry.getCensus());
    }

    @Test
    void getPersonTest() {
        assertNull(censusEntry.getPerson());
    }

    @Test
    void setPersonTest() {
        Person person = GetRandomPerson();
        censusEntry.setPerson(person);
        assertEquals(person, censusEntry.getPerson());
    }

    @Test
    void getOtherPersonTest() {
        assertNull(censusEntry.getOtherPerson());
    }

    @Test
    void setOtherPersonTest() {
        String OtherPerson = GetRandomString();
        censusEntry.setOtherPerson(OtherPerson);
        assertEquals(OtherPerson, censusEntry.getOtherPerson());
    }

    @Test
    void testToStringTest() {
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