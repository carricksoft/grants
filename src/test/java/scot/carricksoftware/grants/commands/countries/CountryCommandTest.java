/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.countries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.commands.places.countries.CountryCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


class CountryCommandTest {

    CountryCommand command;

    @BeforeEach
    void setUp() {
        command = new CountryCommandImpl();
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