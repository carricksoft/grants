/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 02:05. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class CensusCommandTest {

    private CensusCommand command;

    @BeforeEach
    void setUp() {
        command = new CensusCommandImpl();
    }

    @Test
    void getId() {
        assertNull(command.getId());
    }

    @Test
    void setId() {
        Long id = GetRandomLong();
        command.setId(id);
        assertEquals(id, command.getId());
    }

    @Test
    void getDate() {
        assertNull(command.getDate());
    }

    @Test
    void setDate() {
        LocalDate date = LocalDate.now();
        command.setDate(date);
        assertEquals(date, command.getDate());
    }
}