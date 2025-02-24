/*
 * Copyright (c)  21 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.converters.census.censusEntry.CensusEntryConverter;
import scot.carricksoftware.grants.converters.census.censusEntry.CensusEntryConverterImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@SpringBootTest
class CensusEntryConverterTest {

    private CensusEntryConverter converter;

    @BeforeEach
    void setUp() {
        converter = new CensusEntryConverterImpl();
    }

    @Test
    void convertTest() {
        CensusEntry source = new CensusEntry();
        Long id = GetRandomLong();
        Census census = GetRandomCensus();
        Person person = GetRandomPerson();
        String otherPerson = GetRandomString();

        source.setId(id);
        source.setCensus(census);
        source.setPerson(person);
        source.setOtherPerson(otherPerson);

        CensusEntryCommand target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(census, target.getCensus());
        assertEquals(person, target.getPerson());
        assertEquals(otherPerson, target.getOtherPerson());
    }
}