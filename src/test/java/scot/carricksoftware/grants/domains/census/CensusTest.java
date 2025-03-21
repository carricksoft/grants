/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:42. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensusEntry;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomPlace;

public class CensusTest {

    private Census census;


    @BeforeEach
    public void setUp() {
        census = new Census();
    }

    @Test
    public void getDateTest() {
        assertNull(census.getDate());
    }

    @Test
    public void setDateTest() {
        LocalDate localDate = LocalDate.now();
        census.setDate(localDate);
        assertEquals(localDate, census.getDate());
    }

    @Test
    public void getIdTest() {
        assertNull(census.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        census.setId(id);
        assertEquals(id, census.getId());
    }

    @Test
    public void getCensusEntriesTest() {
        assertTrue(census.getCensusEntries().isEmpty());
    }

    @Test
    public void setCensusEntriesTest() {
        List<CensusEntry> censusEntries = new ArrayList<>();
        censusEntries.add(GetRandomCensusEntry());
        census.setCensusEntries(censusEntries);
        assertEquals(censusEntries, census.getCensusEntries());
    }

    @Test
    public void getPlaceTest() {
        assertNull(census.getPlace());
    }

    @Test
    public void setPlaceTest() {
        Place place = GetRandomPlace();
        census.setPlace(place);
        assertEquals(place, census.getPlace());
    }

    @Test
    public void toStringTest() {
        census.setDate(LocalDate.now());
        assertEquals("Census " + LocalDate.now(), census.toString());
    }
}
