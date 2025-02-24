/*
 * Copyright (c)  21 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;

class CensusTest {

    private Census census;

    @BeforeEach
    void setUp() {
        census = new Census();
    }

    @Test
    void getPlace() {
        assertNull(census.getPlace());
    }

    @Test
    void setPlace() {
        Place place = GetRandomPlace();
        census.setPlace(place);
        assertEquals(place, census.getPlace());
    }

    @Test
    void getDate() {
        assertNull(census.getDate());
    }

    @Test
    void setDate() {
        String date = LocalDate.now().format(ApplicationConstants.FORMATTER);
        census.setDate(date);
        assertEquals(date, census.getDate());
    }

    @Test
    void toStringTest() {
        Place place = GetRandomPlace();
        String date = LocalDate.now().format(ApplicationConstants.FORMATTER);
        Census census = new Census();
        census.setPlace(place);
        census.setDate(date);
        assertEquals(place.getName()+", " + date, census.toString());
    }

    @Test
    void getCensusesTest() {
        assertNull(census.getDate());
    }

    @Test
    void setCensusesTest() {
        Set<Census> censusSet = new HashSet<>();
        censusSet.add(GetRandomCensus());
        census.setCensuses(censusSet);
        assertEquals(censusSet, census.getCensuses());
    }

}