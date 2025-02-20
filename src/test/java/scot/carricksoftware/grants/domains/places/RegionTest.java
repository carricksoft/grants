/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@SpringBootTest
class RegionTest {
    Region region;

    @BeforeEach
    void setUp() {
        region = new Region();
    }

    @Test
    void getNameTest() {
        assertNull(region.getName());
    }

    @Test
    void setNameTest() {
        String name = GetRandomString();
        region.setName(name);
        assertEquals(name, region.getName());
    }

    @Test
    void getPlacesTest() {
        assertNull(region.getPlaces());
    }

    @Test
    void setPlacesTest() {
        Place place = GetRandomPlace();
        Set<Place> places = new HashSet<>();
        places.add(place);
        region.setPlaces(places);
        Set<Place> expectedPlaces = region.getPlaces();
        assertTrue(places.containsAll(expectedPlaces));
        assertTrue(expectedPlaces.containsAll(places));
    }


}