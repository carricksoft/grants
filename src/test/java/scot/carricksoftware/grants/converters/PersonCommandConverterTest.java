/*
 * Copyright (c)  11 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

class PersonCommandConverterTest {

    PersonCommandConverter converter = new PersonCommandConverter();
    PersonCommand source;

    @BeforeEach
    void setUp() {
        source = new PersonCommand();
    }

    @Test
    void convert() {
        Long id = GetRandomLong();
        String firstName = GetRandomString();
        String lastName = GetRandomString();

        source.setId(id);
        source.setFirstName(firstName);
        source.setLastName(lastName);

        Person target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(firstName, target.getFirstName());
        assertEquals(lastName, target.getLastName());
    }
}