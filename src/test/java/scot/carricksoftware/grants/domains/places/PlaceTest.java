/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCountry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomRegion;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@SpringBootTest
class PlaceTest {
    Place place;

    @BeforeEach
    void setUp() {
        place = new Place();
    }

    @Test
    void getNameTest() {
        assertNull(place.getName());
    }

    @Test
    void setNameTest() {
        String name = GetRandomString();
        place.setName(name);
        assertEquals(name, place.getName());
    }

    @Test
    void getCountryTest() {
        assertNull(place.getCountry());
    }

    @Test
    void setCountryTest() {
        Country country = GetRandomCountry();
        place.setCountry(country);
        assertEquals(country, place.getCountry());
    }

    @Test
    void getRegionTest() {
        assertNull(place.getRegion());
    }

    @Test
    void setRegionTest() {
        Region region = GetRandomRegion();
        place.setRegion(region);
        assertEquals(region, place.getRegion());
    }

    @Test
    void getIdTest() {
        assertNull(place.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        place.setId(id);
        assertEquals(id, place.getId());
    }


}