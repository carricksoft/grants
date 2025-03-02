/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.places;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@SpringBootTest
public class RegionTest {
    Region region;

    @Before
    public void setUp() {
        region = new Region();
    }

    @Test
    public void getNameTest() {
        assertNull(region.getName());
    }

    @Test
    public void setNameTest() {
        String name = GetRandomString();
        region.setName(name);
        assertEquals(name, region.getName());
    }

    @Test
    public void getPlacesTest() {
        assertNull(region.getPlaces());
    }

    @Test
    public void setPlacesTest() {
        Place place = GetRandomPlace();
        Set<Place> places = new HashSet<>();
        places.add(place);
        region.setPlaces(places);
        Set<Place> expectedPlaces = region.getPlaces();
        assertTrue(places.containsAll(expectedPlaces));
        assertTrue(expectedPlaces.containsAll(places));
    }


}