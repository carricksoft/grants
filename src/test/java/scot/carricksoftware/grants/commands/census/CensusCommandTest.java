/*
 * Copyright (c)  21 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;

class CensusCommandTest {

    private CensusCommand censusCommand;

    @BeforeEach
    void setUp() {
        censusCommand = new CensusCommand();
    }

    @Test
    void getId() {
        assertNull(censusCommand.getId());
    }

    @Test
    void setId() {
        Long id = GetRandomLong();
        censusCommand.setId(id);
        assertEquals(id, censusCommand.getId());
    }

    @Test
    void getPlace() {
        assertNull(censusCommand.getPlace());
    }

    @Test
    void setPlace() {
        Place place = GetRandomPlace();
        censusCommand.setPlace(place);
        assertEquals(place, censusCommand.getPlace());
    }

    @Test
    void getDate() {
        assertNull(censusCommand.getDate());
    }

    @Test
    void setDate() {
        LocalDate date = LocalDate.now();
        censusCommand.setDate(date);
        assertEquals(date, censusCommand.getDate());
    }
}