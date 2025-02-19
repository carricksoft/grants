/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.places.countries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.places.CountryCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

class CountryCommandTest {

    CountryCommand command;

    @BeforeEach
    void setUp() {
        command = new CountryCommand();
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
    void getNameTest() {
        assertNull(command.getName());
    }

    @Test
    void setNameTest() {
        String name = GetRandomString();
        command.setName(name);
        assertEquals(name, command.getName());
    }


}