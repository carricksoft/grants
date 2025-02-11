/*
 * Copyright (c)  11 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

class PersonCommandTest {

    PersonCommand command;

    @BeforeEach
    void setUp() {
        command = new PersonCommand();
    }

    @Test
    void getIdTest() {
        assertNull(command.getId());
    }

    @Test
    void setIdTest() {
        Long Id = GetRandomLong();
        command.setId(Id);
        assertEquals(Id, command.getId());
    }

    @Test
    void getFirstNameTest() {
        assertNull(command.getFirstName());
    }

    @Test
    void setFirstNameTest() {
        String name = GetRandomString();
        command.setFirstName(name);
        assertEquals(name, command.getFirstName());
    }

    @Test
    void getLastNameTest() {
        assertNull(command.getLastName());
    }

    @Test
    void setLastNameTest() {
        String name = GetRandomString();
        command.setLastName(name);
        assertEquals(name, command.getLastName());
    }

}