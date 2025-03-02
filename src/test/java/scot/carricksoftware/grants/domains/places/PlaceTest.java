/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.places;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import scot.carricksoftware.grants.domains.census.Census;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCountry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomRegion;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@SpringBootTest
public class PlaceTest {
    Place place;

    @Before
    public void setUp() {
        place = new Place();
    }

    @Test
    public void getNameTest() {
        assertNull(place.getName());
    }

    @Test
    public void setNameTest() {
        String name = GetRandomString();
        place.setName(name);
        assertEquals(name, place.getName());
    }

    @Test
    public void getCountryTest() {
        assertNull(place.getCountry());
    }

    @Test
    public void setCountryTest() {
        Country country = GetRandomCountry();
        place.setCountry(country);
        assertEquals(country, place.getCountry());
    }

    @Test
    public void getRegionTest() {
        assertNull(place.getRegion());
    }

    @Test
    public void setRegionTest() {
        Region region = GetRandomRegion();
        place.setRegion(region);
        assertEquals(region, place.getRegion());
    }

    @Test
    public void getIdTest() {
        assertNull(place.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        place.setId(id);
        assertEquals(id, place.getId());
    }

    @Test
    public void getCensusesTest() {
        assertNull(place.getCensuses());
    }

    @Test
    public void setCensusesTest() {
        Census census = GetRandomCensus();
        Set<Census> censusSet = new HashSet<>();
        censusSet.add(census);
        place.setCensuses(censusSet);
        Set<Census> expectedCensusSet = place.getCensuses();
        assertTrue(censusSet.containsAll(expectedCensusSet));
        assertTrue(expectedCensusSet.containsAll(censusSet));
    }

    @Test
    public void getGetToStringNullTest() {
        assertEquals("", place.toString());
    }

    @Test
    public void getGetToStringNotNullTest() {
        Region region = GetRandomRegion();
        Country country = GetRandomCountry();
        String name = GetRandomString();
        place.setRegion(region);
        place.setCountry(country);
        place.setName(name);
        String requiredResult = name + ", " + region.getName() + ", " + country.getName();
        assertEquals(requiredResult, place.toString());
    }


}