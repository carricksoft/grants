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
public class CountryTest {
    Country country;

    @Before
    public void setUp() {
        country = new Country();
    }

    @Test
    public void getNameTest() {
        assertNull(country.getName());
    }

    @Test
    public void setNameTest() {
        String name = GetRandomString();
        country.setName(name);
        assertEquals(name, country.getName());
    }

    @Test
    public void getPlacesTest() {
        assertNull(country.getPlaces());
    }

    @Test
    public void setPlacesTest() {
        Place place = GetRandomPlace();
        Set<Place> places = new HashSet<>();
        places.add(place);
        country.setPlaces(places);
        Set<Place> expectedPlaces = country.getPlaces();
        assertTrue(places.containsAll(expectedPlaces));
        assertTrue(expectedPlaces.containsAll(places));

    }


}