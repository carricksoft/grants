/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.regions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@Component
class RegionConverterImplTest {

    final RegionConverterImpl converter = new RegionConverterImpl();
    Region source;

    @BeforeEach
    void setUp() {
        source = new Region();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        String name = GetRandomString();
        Set<Place> places = new HashSet<>();
        places.add(new Place());

        source.setId(id);
        source.setName(name);
        source.setPlaces(places);

        RegionCommand target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());
        Set<Place> targetPlaces = target.getPlaces();
        assertTrue(places.containsAll(targetPlaces));
        assertTrue(targetPlaces.containsAll(places));
    }

}