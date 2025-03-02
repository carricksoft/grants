/*
 * Copyright (c)  21 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.census;

import org.junit.Before;

import org.junit.Test;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;

public class CensusCommandTest {

    private CensusCommand censusCommand;

    @Before
    public void setUp() {
        censusCommand = new CensusCommand();
    }

    @Test
    public void getId() {
        assertNull(censusCommand.getId());
    }

    @Test
    public void setId() {
        Long id = GetRandomLong();
        censusCommand.setId(id);
        assertEquals(id, censusCommand.getId());
    }

    @Test
    public void getPlace() {
        assertNull(censusCommand.getPlace());
    }

    @Test
    public void setPlace() {
        Place place = GetRandomPlace();
        censusCommand.setPlace(place);
        assertEquals(place, censusCommand.getPlace());
    }

    @Test
    public void getDate() {
        assertNull(censusCommand.getDate());
    }

    @Test
    public void setDate() {
        String date = LocalDate.now().format(ApplicationConstants.FORMATTER);
        censusCommand.setDate(date);
        assertEquals(date, censusCommand.getDate());
    }

    @Test
    public void getCensusEntriesTest() {
        assertNull(censusCommand.getCensusEntries());
    }

    @Test
    public void setCensusEntriesTest() {
        Set<CensusEntry> censusEntries = new HashSet<>();
        censusEntries.add(GetRandomCensusEntry());
        censusCommand.setCensusEntries(censusEntries);
        assertEquals(censusEntries, censusCommand.getCensusEntries());
    }
}