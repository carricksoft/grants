/*
 * Copyright (c)  21 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;

class CensusTest {

    private Census census;

    @BeforeEach
    void setUp() {
        census = new Census();
    }

    @Test
    void getPlace(){
        assertNull(census.getPlace());
    }

    @Test
    void setPlace() {
        Place place  = GetRandomPlace();
        census.setPlace(place);
        assertEquals(place, census.getPlace());
    }

    @Test
    void getDate() {
        assertNull(census.getDate());
    }

    @Test
    void setDate() {
        LocalDate date = LocalDate.now();
        census.setDate(date);
        assertEquals(date, census.getDate());
    }
}