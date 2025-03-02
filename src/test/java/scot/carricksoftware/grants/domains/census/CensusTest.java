/*
 * Copyright (c)  21 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.census;


import org.junit.Before;
import org.junit.Test;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;

public class CensusTest {

    private Census census;

    @Before
    public void setUp() {
        census = new Census();
    }

    @Test
    public void getPlace() {
        assertNull(census.getPlace());
    }

    @Test
    public void setPlace() {
        Place place = GetRandomPlace();
        census.setPlace(place);
        assertEquals(place, census.getPlace());
    }

    @Test
    public void getDate() {
        assertNull(census.getDate());
    }

    @Test
    public void setDate() {
        String date = LocalDate.now().format(ApplicationConstants.FORMATTER);
        census.setDate(date);
        assertEquals(date, census.getDate());
    }

    @Test
    public void toStringTest() {
        Place place = GetRandomPlace();
        String date = LocalDate.now().format(ApplicationConstants.FORMATTER);
        Census census = new Census();
        census.setPlace(place);
        census.setDate(date);
        assertEquals(place.getName() + ", " + date, census.toString());
    }

    @Test
    public void getCensusEntriesTest() {
        assertNull(census.getCensusEntries());
    }

    @Test
    public void setCensusEntriesTest() {
        Set<CensusEntry> censusEntries = new HashSet<>();
        censusEntries.add(GetRandomCensusEntry());
        census.setCensusEntries(censusEntries);
        assertEquals(censusEntries, census.getCensusEntries());
    }


}