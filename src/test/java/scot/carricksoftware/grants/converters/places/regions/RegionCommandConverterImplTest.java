/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.places.regions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

class RegionCommandConverterImplTest {

    final RegionCommandConverterImpl converter = new RegionCommandConverterImpl();
    RegionCommand source;

    @BeforeEach
    void setUp() {
        source = new RegionCommand();
    }

    @Test
    void convert() {
        Long id = GetRandomLong();
        String name = GetRandomString();
        Set<Place> places = new HashSet<>();
        places.add(new Place());

        source.setId(id);
        source.setName(name);
        source.setPlaces(places);


        Region target = converter.convert(source);
        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());
        assertEquals(places, target.getPlaces());
    }
}