/*
 * Copyright (c)  11 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@Component
class PersonConverterTest {

    final PersonConverter converter = new PersonConverter();
    Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    public void convertTest() {
        Long id = GetRandomLong();
        String firstName = GetRandomString();
        String lastName = GetRandomString();

        person.setId(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);

        PersonCommand command = converter.convert(person);
        assert command != null;
        assertEquals(id, command.getId());
        assertEquals(firstName, command.getFirstName());
        assertEquals(lastName, command.getLastName());
    }

}