/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.people;


import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.census.CensusEntry;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@SpringBootTest
public class PersonTest {
    Person person;

    @Before
    public void setUp() {
        person = new Person();
    }

    @Test
    public void getFirstName() {
        assertNull(person.getFirstName());
    }

    @Test
    public void setFirstName() {
        String name = GetRandomString();
        person.setFirstName(name);
        assertEquals(name, person.getFirstName());
    }

    @Test
    public void getLastName() {
        assertNull(person.getLastName());
    }

    @Test
    public void setLastName() {
        String name = GetRandomString();
        person.setLastName(name);
        assertEquals(name, person.getLastName());
    }

    @Test
    public void getCensusEntriesTest() {
        assertNull(person.getCensusEntries());
    }

    @Test
    public void setCensusEntries() {
        Set<CensusEntry> censusEntries = new HashSet<>();
        censusEntries.add(GetRandomCensusEntry());
        person.setCensusEntries(censusEntries);
        assertEquals(censusEntries, person.getCensusEntries());
    }

    @Test
    public void toStringTest() {
        person.setLastName(GetRandomString());
        person.setFirstName(GetRandomString());
        assertEquals(person.getLastName() + ", " + person.getFirstName(), person.toString());
    }


}