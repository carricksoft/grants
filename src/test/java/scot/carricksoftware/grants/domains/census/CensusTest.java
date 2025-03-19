/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:42. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

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
}
