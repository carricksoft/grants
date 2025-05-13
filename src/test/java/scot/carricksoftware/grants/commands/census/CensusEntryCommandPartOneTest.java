/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:15. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class CensusEntryCommandPartOneTest {

    private CensusEntryCommand command;

    @BeforeEach
    void setUp() {
        command = new CensusEntryCommandImpl();
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        command.setId(id);
        assertEquals(id, command.getId());
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

    @Test
    void getBirthDayTest() {
        assertNull(command.getBirthDay());
    }

    @Test
    void setBirthDayTest() {
        String birthDay = GetRandomString();
        command.setBirthDay(birthDay);
        assertEquals(birthDay, command.getBirthDay());
    }

    @Test
    void getBirthYearTest() {
        assertNull(command.getBirthYear());
    }

    @Test
    void setBirthYearTest() {
        String birthYear = GetRandomString();
        command.setBirthYear(birthYear);
        assertEquals(birthYear, command.getBirthYear());
    }

    @Test
    void getPersonalOccupationTest() {
        assertNull(command.getPersonalOccupation());
    }

    @Test
    void setPersonalOccupationTest() {
        String personalOccupation = GetRandomString();
        command.setPersonalOccupation(personalOccupation);
        assertEquals(personalOccupation, command.getPersonalOccupation());
    }


}