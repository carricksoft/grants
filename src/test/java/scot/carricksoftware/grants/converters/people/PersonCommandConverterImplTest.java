/*
 * Copyright (c)  16 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.people;


import org.junit.Before;
import org.junit.Test;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

public class PersonCommandConverterImplTest {

    final PersonCommandConverterImpl converter = new PersonCommandConverterImpl();
    PersonCommand source;

    @Before
    public void setUp() {
        source = new PersonCommand();
    }

    @Test
    public void convert() {
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