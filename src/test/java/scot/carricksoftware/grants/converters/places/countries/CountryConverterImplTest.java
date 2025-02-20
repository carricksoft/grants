/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.countries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;

@Component
class CountryConverterImplTest {

    final CountryConverterImpl converter = new CountryConverterImpl();
    Country source;

    @BeforeEach
    void setUp() {
        source = new Country();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        String name = GetRandomString();
        Set<Place> places = new HashSet<>();
        places.add(GetRandomPlace());

        source.setId(id);
        source.setName(name);
        source.setPlaces(places);

        CountryCommand target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());
        Set<Place> expectedPlaces = target.getPlaces();
        assertTrue(expectedPlaces.containsAll(places));
        assertTrue(places.containsAll(expectedPlaces));
    }

}