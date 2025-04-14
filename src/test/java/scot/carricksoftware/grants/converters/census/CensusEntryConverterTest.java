/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:37. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryRelationship;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryCondition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCensusEntryRandomEnums.GetRandomCensusEntryCondition;
import static scot.carricksoftware.grants.GenerateCensusEntryRandomEnums.GetRandomCensusEntryRelationship;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class CensusEntryConverterTest {

    private CensusEntryConverter converter;

    @BeforeEach
    void setUp() {
        converter = new CensusEntryConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        String name = GetRandomString();
        Census census = GetRandomCensus();
        CensusEntry source = new CensusEntry();
        CensusEntryRelationship relationship = GetRandomCensusEntryRelationship();
        CensusEntryCondition condition = GetRandomCensusEntryCondition();
        Person person = GetRandomPerson();

        source.setId(id);
        source.setName(name);
        source.setCensus(census);
        source.setPerson(person);
        source.setRelationship(relationship);
        source.setCondition(condition);

        CensusEntryCommand target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());
        assertEquals(census, target.getCensus());
        assertEquals(person, target.getPerson());
        assertEquals(relationship, target.getRelationship());
        assertEquals(condition, target.getCondition());
    }
}